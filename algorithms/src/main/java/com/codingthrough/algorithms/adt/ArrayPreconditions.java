package com.codingthrough.algorithms.adt;

/**
 * This class consists of {@code static} utility methods that
 * help a method or constructor check whether it is invoked
 * correctly, in other words, whether all its preconditions are met.
 */
public class ArrayPreconditions {
    /**
     * This class should not be instantiated.
     */
    private ArrayPreconditions() {
    }

    /**
     * Ensures that indexes are inside array bounds, throws an exception if they are not.
     *
     * @param size  the length of the array
     * @param start the lowest index
     * @param end   the highest index
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static void ensureBounds(int size, int start, int end) {
        ensureIndex(size, start);
        ensureIndex(size, end);
        ensureIndexes(start, end);
    }

    /**
     * Ensures that index is inside array bounds, throws an exception if they is not.
     *
     * @param size  the length of the array
     * @param index the array index
     * @throws IllegalArgumentException if the specified index is outside of array bounds
     */
    public static void ensureIndex(int size, int index) {
        if (index < 0) {
            final String message = String.format("Index (%d) should not be negative.", index);
            throw new IllegalArgumentException(message);
        }

        if (index >= size) {
            final String message = String.format("Index (%d) should be less than size (%d).", index, size);
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Ensures that indexes are in order, throws an exception if they are not.
     *
     * @param start the start index
     * @param end   the end index
     * @throws IllegalArgumentException if the specified indexes are not in order of growth
     */
    public static void ensureIndexes(int start, int end) {
        if (start > end) {
            final String message = String.format("Start (%d) should not be grater than end (%d).", start, end);
            throw new IllegalArgumentException(message);
        }
    }
}
