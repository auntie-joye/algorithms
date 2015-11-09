package com.codingthrough.algorithms.collection;

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
     * Ensures that indexes are inside array bounds, throws an exception if they aren't.
     *
     * @param length the length of the array
     * @param lo     the lowest index
     * @param hi     the highest index
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static void requireBounds(int length, int lo, int hi) {
        if (lo > hi) {
            throw new IllegalArgumentException("[lo] index is greater than [hi] index.");
        }

        if (lo > length) {
            throw new IllegalArgumentException("[lo] index should be inside array bounds.");
        }

        if (hi < 0) {
            throw new IllegalArgumentException("[hi] index should be inside array bounds.");
        }
    }
}
