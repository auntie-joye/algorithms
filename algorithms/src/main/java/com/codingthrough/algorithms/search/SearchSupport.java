package com.codingthrough.algorithms.search;

import com.codingthrough.algorithms.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;

import static com.codingthrough.algorithms.adt.ArrayPreconditions.ensureBounds;

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
    public static <T extends Comparable<T>> boolean less(@Nonnull T a, @Nonnull T b) {
        Preconditions.ensureNotNull(a, "Argument [a] should not be null.");
        Preconditions.ensureNotNull(b, "Argument [b] should not be null.");

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
    public static <T> boolean less(@Nullable T a, @Nullable T b, @Nonnull Comparator<T> c) {
        Preconditions.ensureNotNull(c, "Comparator [c] should not be null.");

        return c.compare(a, b) < 0;
    }

    /**
     * @return true if {@param a} is greater than {@param b}
     * @throws IllegalArgumentException if one of the input value is {@code null},
     *                                  or both are {@code null}
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> boolean greater(@Nonnull T a, @Nonnull T b) {
        Preconditions.ensureNotNull(a, "Argument [a] should not be null.");
        Preconditions.ensureNotNull(b, "Argument [b] should not be null.");

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
    public static <T> boolean greater(@Nullable T a, @Nullable T b, @Nonnull Comparator<T> c) {
        Preconditions.ensureNotNull(c, "Comparator [c] should not be null.");

        return c.compare(a, b) > 0;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public static <T extends Comparable<T>> boolean sorted(@Nonnull T[] a) {
        return sorted(a, 0, a.length - 1);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static <T extends Comparable<T>> boolean sorted(@Nonnull T[] a, int lo, int hi) {
        Preconditions.ensureNotNull(a, "Array [a] should not be null.");
        ensureBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified comparator is {@code null}
     */
    public static <T> boolean sorted(@Nonnull T[] a, @Nonnull Comparator<T> c) {
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
    public static <T> boolean sorted(@Nonnull T[] a, int lo, int hi, @Nonnull Comparator<T> c) {
        Preconditions.ensureNotNull(a, "Array [a] should not be null.");
        ensureBounds(a.length, lo, hi);
        Preconditions.ensureNotNull(c, "Comparator [c] should not be null.");

        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1], c)) {
                return false;
            }
        }

        return true;
    }
}
