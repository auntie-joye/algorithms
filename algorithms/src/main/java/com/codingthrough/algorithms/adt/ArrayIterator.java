package com.codingthrough.algorithms.adt;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;
import static com.codingthrough.algorithms.adt.ArrayPreconditions.ensureBounds;
import static com.codingthrough.algorithms.adt.ArrayPreconditions.ensureIndex;

/**
 * Array iterator over the elements in the specified array,
 * starting at the specified position and (optional)
 * ending at the specified position in the array.
 * The specified index indicates the first element that would be
 * returned by an initial call to {@link ArrayIterator#next}.
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * The array to ne iterated.
     */
    private final E[] a;

    /**
     * The current iteration position.
     */
    private int index = 0;

    /**
     * The last index to be iterated.
     */
    private int lastIndex;

    /**
     * Creates new iterator over the specified array starting at
     * position zero till the end of the array.
     *
     * @param a the array to be iterated
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public ArrayIterator(@Nonnull E[] a) {
        ensureNotNull(a);

        this.a = a;
        this.lastIndex = a.length - 1;
    }

    /**
     * Creates new iterator over the specified array starting at
     * the specified position till the end of the array.
     *
     * @param a     the array to be iterated
     * @param index the starting position for iteration
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified index is outside of the array bounds
     */
    public ArrayIterator(@Nonnull E[] a, int index) {
        ensureNotNull(a);
        ensureIndex(a.length, index);

        this.a = a;
        this.index = index;
        this.lastIndex = a.length - 1;
    }

    /**
     * Creates new iterator over the specified array starting at
     * the specified position till the specified upper bound.
     *
     * @param a     the array to be iterated
     * @param start the starting position for iteration
     * @param end   the ending position for iteration
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified indexes are outside of the array bounds
     */
    public ArrayIterator(@Nonnull E[] a, int start, int end) {
        ensureNotNull(a);
        ensureBounds(a.length, start, end);

        this.a = a;
        this.index = start;
        this.lastIndex = end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return index <= lastIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E next() {
        if (index > lastIndex) {
            throw new NoSuchElementException();
        }
        return a[index++];
    }
}
