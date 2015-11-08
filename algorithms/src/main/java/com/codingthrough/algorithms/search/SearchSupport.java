package com.codingthrough.algorithms.search;

import java.util.Comparator;

/**
 * Provides a number of static auxiliary methods for different search algorithm implementations.
 */
public abstract class SearchSupport {
    /**
     * This class should not be instantiated.
     */
    protected SearchSupport() {
    }

    /**
     * @return true if {@param a} is less than {@param b}.
     */
    @SuppressWarnings("unchecked")
    protected static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * @return true if {@param a} is less than {@param b} using comparator {@param c}.
     */
    @SuppressWarnings("unchecked")
    protected static <T> boolean less(T a, T b, Comparator<T> c) {
        return c.compare(a, b) < 0;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false.
     */
    public static <T extends Comparable<T>> boolean sorted(T[] a) {
        return sorted(a, 0, a.length - 1);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false.
     */
    public static <T extends Comparable<T>> boolean sorted(T[] a, int lo, int hi) {
        checkBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false.
     */
    public static <T> boolean sorted(T[] a, Comparator<T> c) {
        return sorted(a, 0, a.length - 1, c);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false.
     */
    public static <T> boolean sorted(T[] a, int lo, int hi, Comparator<T> c) {
        checkBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1], c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks that indexes are inside array bounds, throws an exception if they aren't.
     *
     * @param length the length of the array
     * @param lo     the lowest index
     * @param hi     the highest index
     */
    protected static void checkBounds(int length, int lo, int hi) {
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
