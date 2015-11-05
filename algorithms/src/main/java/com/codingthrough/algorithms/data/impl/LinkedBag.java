package com.codingthrough.algorithms.data.impl;

import com.codingthrough.algorithms.data.Bag;

import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implementation uses a singly-linked list with a static nested class Node.
 */
public class LinkedBag<E> extends AbstractBag<E> {
    /**
     * Pointer to first node.
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
     * @throws NullPointerException if the specified bag is null
     */
    public LinkedBag(final Bag<E> bag) {
        this();
        addAll(bag);
    }

    /**
     * Constructs a bag containing the elements of the specified
     * array.
     *
     * @param a the array whose elements are to be placed into this bag
     * @throws NullPointerException if the specified array is null
     */
    public LinkedBag(final E[] a) {
        this();
        addAll(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(final E item) {
        first = new Node(item, first);
        size++;
        modCount++;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(final E[] a) {
        boolean added = false;
        for (E item : a) {
            if (add(item)) {
                added = true;
            }
        }

        return added;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(final Bag<E> bag) {
        boolean added = false;
        for (E item : bag) {
            if (add(item)) {
                added = true;
            }
        }

        return added;
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
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
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
     * The bag-iterator is <i>fail-fast</i>: if the baf is structurally
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
