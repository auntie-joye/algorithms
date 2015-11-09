package com.codingthrough.algorithms.search;

import java.util.Comparator;

import static com.codingthrough.algorithms.Preconditions.requireNotNull;
import static com.codingthrough.algorithms.collection.ArrayPreconditions.requireBounds;

/**
 * This class consists of {@code static} utility methods for different
 * search algorithm implementations.
 */
public abstract class SearchSupport {
    /**
     * This class should not be instantiated.
     */
    protected SearchSupport() {
    }

    /**
     * @return true if {@param a} is less than {@param b}
     * @throws IllegalArgumentException if one of the input value is {@code null},
     *                                  or both are {@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> boolean less(T a, T b) {
        requireNotNull(a, "Argument [a] should not be null.");
        requireNotNull(b, "Argument [b] should not be null.");

        return a.compareTo(b) < 0;
    }

    /**
     * Compares arguments using the specified comparator, as method does
     * not check arguments for nullity, comparator should handle possible {@code null} values
     * in both input arguments.
     *
     * @return true if {@param a} is less than {@param b} using comparator {@param c}
     * @throws IllegalArgumentException if the specified comparator is {@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean less(T a, T b, Comparator<T> c) {
        requireNotNull(c, "Comparator [c] should not be null.");

        return c.compare(a, b) < 0;
    }

    /**
     * @return true if {@param a} is greater than {@param b}
     * @throws IllegalArgumentException if one of the input value is {@code null},
     *                                  or both are {@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> boolean greater(T a, T b) {
        requireNotNull(a, "Argument [a] should not be null.");
        requireNotNull(b, "Argument [b] should not be null.");

        return a.compareTo(b) > 0;
    }

    /**
     * Compares arguments using the specified comparator, as method does
     * not check arguments for nullity, comparator should handle possible {@code null} values
     * in both input arguments.
     *
     * @return true if {@param a} is greater than {@param b} using comparator {@param c}
     * @throws IllegalArgumentException if the specified comparator is {@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean greater(T a, T b, Comparator<T> c) {
        requireNotNull(c, "Comparator [c] should not be null.");

        return c.compare(a, b) > 0;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public static <T extends Comparable<T>> boolean sorted(T[] a) {
        return sorted(a, 0, a.length - 1);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static <T extends Comparable<T>> boolean sorted(T[] a, int lo, int hi) {
        requireNotNull(a, "Array [a] should not be null.");
        requireBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false
     */
    public static <T> boolean sorted(T[] a, Comparator<T> c) {
        return sorted(a, 0, a.length - 1, c);
    }

    /**
     * Compares arguments using the specified comparator, as method does
     * not check arguments for nullity, comparator should handle possible {@code null} values
     * in both input arguments.
     *
     * @return true if {@param a} array inside bounds is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     * @throws IllegalArgumentException if the specified comparator is {@code null}
     */
    public static <T> boolean sorted(T[] a, int lo, int hi, Comparator<T> c) {
        requireNotNull(a, "Array [a] should not be null.");
        requireBounds(a.length, lo, hi);
        requireNotNull(c, "Comparator [c] should not be null.");

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1], c)) {
                return false;
            }
        }

        return true;
    }
}
