package com.codingthrough.algorithms.sort;

import java.util.Comparator;

/**
 * The <tt>Insertion</tt> provides a number of static methods to sort an array
 * using insertion sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Wikipedia article - Insertion Sort</a>.
 * </p>
 */
public class Insertion {
    /**
     * This class should not be instantiated.
     */
    private Insertion() {
    }

    /**
     * Rearranges the array in ascending order using the natural order.
     *
     * @param a the array to be sorted
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the natural order.
     *
     * @param a  the array to be sorted
     * @param lo the lowest index
     * @param hi the highest index
     */
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        checkBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            T cur = a[i];
            for (int j = i; j >= lo; j--) {
                if (j > lo && less(cur, a[j - 1])) {
                    a[j] = a[j - 1];
                } else {
                    a[j] = cur;
                    break;
                }
            }
        }

        assert sorted(a, lo, hi);
    }

    /**
     * Rearranges the array in ascending order using the comparator.
     *
     * @param a the array to be sorted
     * @param c the comparator specifying the order
     */
    public static <T> void sort(T[] a, Comparator<T> c) {
        sort(a, 0, a.length - 1, c);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the comparator.
     *
     * @param a  the array to be sorted
     * @param lo the lowest index
     * @param hi the highest index
     * @param c  the comparator specifying the order
     */
    public static <T> void sort(T[] a, int lo, int hi, Comparator<T> c) {
        checkBounds(a.length, lo, hi);

        for (int i = lo + 1; i <= hi; i++) {
            T cur = a[i];
            for (int j = i; j >= lo; j--) {
                if (j > lo && less(cur, a[j - 1], c)) {
                    a[j] = a[j - 1];
                } else {
                    a[j] = cur;
                    break;
                }
            }
        }

        assert sorted(a, lo, hi, c);
    }

    /**
     * @return true if {@param a} is less than {@param b}.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * @return true if {@param a} is less than {@param b} using comparator {@param c}.
     */
    @SuppressWarnings("unchecked")
    private static <T> boolean less(T a, T b, Comparator<T> c) {
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
     * Checks that indexes are inside array bounds and throws an exception if they aren't.
     *
     * @param length the length of the array
     * @param lo     the lowest index
     * @param hi     the highest index
     */
    private static void checkBounds(int length, int lo, int hi) {
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
