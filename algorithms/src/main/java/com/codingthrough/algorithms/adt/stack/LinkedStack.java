
package com.codingthrough.algorithms.adt.stack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;

/**
 * This implementation uses a singly-linked list with a static nested class for
 * linked-list nodes.
 */

public class LinkedStack<E> extends AbstractStack<E> {
    /**
     * Pointer to first node.
     */
    private Node first;

    /**
     * Constructs an empty stack.
     */
    public LinkedStack() {
    }

    /**
     * Constructs a stack containing the elements of the specified
     * iterable collection.
     *
     * @param iterable the iterable collection whose elements are to be placed into this stack
     * @throws IllegalArgumentException if the specified iterable collection is {@code null}
     */
    public LinkedStack(@Nonnull final Iterable<E> iterable) {
        ensureNotNull(iterable);

        pushAll(iterable);
    }

    /**
     * Constructs a stack containing the elements of the specified
     * iterable collection.
     *
     * @param it the iterator oer collection whose elements are to be placed into this stack
     * @throws IllegalArgumentException if the specified iterator is {@code null}
     */
    public LinkedStack(@Nonnull final Iterator<E> it) {
        ensureNotNull(it);

        pushAll(it);
    }

    /**
     * Constructs a stack containing the elements of the specified
     * array.
     *
     * @param a the array whose elements are to be placed into this stack
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public LinkedStack(@Nonnull final E[] a) {
        ensureNotNull(a);

        pushAll(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(@Nullable E item) {
        first = new Node(item, first);
        size++;
        modCount++;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @Override
    public void pushAll(@Nonnull E[] a) {
        ensureNotNull(a);

        for (E item : a) {
            push(item);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified iterable collection is {@code null}
     */
    @Override
    public void pushAll(@Nonnull Iterable<E> iterable) {
        ensureNotNull(iterable);
        pushAll(iterable.iterator());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified iterator is {@code null}
     */
    @Override
    public void pushAll(@Nonnull Iterator<E> it) {
        ensureNotNull(it);
        while (it.hasNext()) {
            push(it.next());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws EmptyStackException if stack is empty.
     */
    @Override
    public E pop() {
        ensureNotEmpty();

        E item = first.item;
        first = first.next;
        size--;
        modCount++;

        return item;
    }

    /**
     * {@inheritDoc}
     *
     * @throws EmptyStackException if stack is empty.
     */
    @Override
    public E peek() {
        ensureNotEmpty();
        return first.item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.next = null;
            current = next;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        final Object[] a = new Object[size];

        int i = 0;
        for (Node cur = first; cur != null; cur = cur.next) {
            a[i++] = cur.item;
        }

        return a;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(@Nonnull T[] a) {
        ensureNotNull(a);

        if (a.length < size) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        }

        int i = 0;
        for (Node cur = first; cur != null; cur = cur.next) {
            a[i++] = (T) cur.item;
        }

        return a;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new StackIterator(first);
    }

    /**
     * Nested child class that represents single node in the linked list.
     */
    private class Node {
        E item;
        Node next;

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * The stack-iterator is <i>fail-fast</i>: if the stack is structurally
     * modified at any time after the Iterator is created, in any way,
     * the stack-iterator will throw a {@code ConcurrentModificationException}.
     * <p>
     * Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,
     * rather than risking arbitrary, non-deterministic behavior at an undetermined
     * time in the future.
     */
    private final class StackIterator implements Iterator<E> {
        private Node current;
        private int expectedModCount = modCount;

        StackIterator(final Node node) {
            current = node;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E item = current.item;
            current = current.next;

            return item;
        }

        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
