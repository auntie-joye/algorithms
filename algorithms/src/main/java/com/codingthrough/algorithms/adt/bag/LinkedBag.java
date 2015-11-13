package com.codingthrough.algorithms.adt.bag;

import com.codingthrough.algorithms.adt.ArrayIterator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;

/**
 * This implementation uses a singly-linked list with a static nested class Node.
 */
public class LinkedBag<E> extends AbstractBag<E> {
    /**
     * Pointer to the first node.
     */
    private Node first;

    /**
     * Constructs an empty bag.
     */
    public LinkedBag() {
    }

    /**
     * Constructs a bag containing the elements of the specified
     * bag.
     *
     * @param bag the bag whose elements are to be placed into this bag
     * @throws IllegalArgumentException if the specified bag is {@code null}
     */
    public LinkedBag(@Nonnull final Bag<E> bag) {
        this();
        addAll(bag);
    }

    /**
     * Constructs a bag containing the elements of the specified
     * array.
     *
     * @param a the array whose elements are to be placed into this bag
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public LinkedBag(@Nonnull final E[] a) {
        this();
        addAll(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(@Nullable final E item) {
        first = new Node(item, first);
        size++;
        modCount++;
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @Override
    public boolean addAll(@Nonnull final E[] a) {
        return addAll(new ArrayIterator<>(a));
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified collection is {@code null}
     */
    @Override
    public boolean addAll(@Nonnull final Iterable<E> a) {
        ensureNotNull(a);
        return addAll(a.iterator());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified iterator is {@code null}
     */
    @Override
    public boolean addAll(@Nonnull Iterator<E> a) {
        ensureNotNull(a);

        boolean added = false;
        while (a.hasNext()) {
            if (add(a.next())) {
                added = true;
            }
        }

        return added;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        modCount++;

        Node cur = first;
        while (cur != null) {
            Node next = cur.next;
            cur.item = null;
            cur.next = null;
            cur = next;
        }

        first = null;
        size = 0;
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
     * @throws IllegalArgumentException if the specified array {@code null}
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
        return new BagIterator(first);
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
     * The bag-iterator is <i>fail-fast</i>: if the bag is structurally
     * modified at any time after the Iterator is created, in any way,
     * the bag-iterator will throw a {@code ConcurrentModificationException}.
     * <p>
     * Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,
     * rather than risking arbitrary, non-deterministic behavior at an undetermined
     * time in the future.
     */
    private final class BagIterator implements Iterator<E> {
        private Node current;
        private int expectedModCount = modCount;

        BagIterator(final Node node) {
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
