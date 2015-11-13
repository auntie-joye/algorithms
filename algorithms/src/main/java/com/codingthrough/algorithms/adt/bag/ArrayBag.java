package com.codingthrough.algorithms.adt.bag;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;

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
     * @throws IllegalArgumentException if the specified bag is {@code null}
     */
    @SuppressWarnings("unchecked")
    public ArrayBag(@Nonnull final Bag<E> bag) {
        ensureNotNull(bag);

        items = (E[]) new Object[bag.size()];
        addAll(bag);
    }

    /**
     * Constructs a bag containing the elements of the specified
     * array.
     *
     * @param a the array whose elements are to be placed into this bag
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @SuppressWarnings("unchecked")
    public ArrayBag(@Nonnull final E[] a) {
        ensureNotNull(a);

        items = (E[]) new Object[a.length];
        addAll(a);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(@Nullable E item) {
        ensureCapacity(size + 1);

        items[size++] = item;
        modCount++;

        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @Override
    public boolean addAll(@Nonnull E[] a) {
        ensureNotNull(a);

        if (a.length == 0) {
            return false;
        }

        ensureCapacity(size + a.length);

        modCount++;
        System.arraycopy(a, 0, items, size, a.length);
        size += a.length;

        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if the specified iterable collection is {@code null}
     */
    @Override
    public boolean addAll(@Nonnull Iterable<E> a) {
        ensureNotNull(a);

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

        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
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
     *
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(@Nonnull T[] a) {
        ensureNotNull(a);

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
