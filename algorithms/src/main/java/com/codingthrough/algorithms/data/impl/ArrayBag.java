package com.codingthrough.algorithms.data.impl;

import com.codingthrough.algorithms.data.Bag;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implementation uses a resizing array.
 */
public class ArrayBag<E> extends AbstractBag<E> {
    /**
     * Default initial capacity.
     */
    private static final Integer DEFAULT_CAPACITY = 10;

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * The array buffer into which the elements of the bag are stored.
     * The capacity of the bag is the length of this array buffer.
     */
    private E[] items;

    /**
     * Constructs an empty bag of default capacity.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty bag of the specified capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        items = (E[]) new Object[capacity];
    }

    /**
     * Constructs a bag containing the elements of the specified
     * bag.
     *
     * @param bag the bag whose elements are to be placed into this bag
     * @throws NullPointerException if the specified bag is null
     */
    public ArrayBag(final Bag<E> bag) {
        this(bag.size());
        addAll(bag);
    }

    /**
     * Constructs a bag containing the elements of the specified
     * array.
     *
     * @param a the array whose elements are to be placed into this bag
     * @throws NullPointerException if the specified array is null
     */
    public ArrayBag(final E[] a) {
        this(a.length);
        addAll(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E item) {
        ensureCapacity(size + 1);

        items[size++] = item;
        modCount++;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(E[] a) {
        ensureCapacity(size + a.length);
        System.arraycopy(a, 0, items, size, a.length);
        size += a.length;
        return a.length != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Bag<E> bag) {
        Object[] a = bag.toArray();
        ensureCapacity(size + a.length);
        System.arraycopy(a, 0, items, size, a.length);
        size += a.length;
        return a.length != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(items, size, a.getClass());
        }

        System.arraycopy(items, 0, a, 0, size);

        return a;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<E> iterator() {
        return new BagIterator(items, size);
    }

    private void ensureCapacity(int minSize) {
        if (minSize > items.length) {
            int newSize = size * 2;

            if (newSize < minSize) {
                newSize = minSize;
            }
            if (newSize > MAX_ARRAY_SIZE) {
                newSize = Integer.MAX_VALUE;
            }

            resize(newSize);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int size) {
        if (size < 0) {
            throw new OutOfMemoryError();
        }

        items = Arrays.copyOf(items, size);
        modCount++;
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
    private class BagIterator implements Iterator<E> {
        private E[] items;
        private int size;
        private int cursor;
        private int expectedModCount = modCount;

        BagIterator(E[] items, int size) {
            this.items = items;
            this.size = size;
        }

        public boolean hasNext() {
            return cursor != size;
        }

        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[cursor++];
        }

        private void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
