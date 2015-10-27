package com.codingthrough.algorithms.sort;

import java.util.Comparator;

/**
 * The <tt>Shell</tt> provides a number of static methods to sort an array
 * using shell sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Shellsort">Wikipedia article - Shell Sort</a>.
 * </p>
 */
public class Shell extends SortSupport {
    /**
     * This class should not be instantiated.
     */
    private Shell() {
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

        int n = hi - lo + 1;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = lo + h; i <= hi; i++) {
                for (int j = i; j >= lo + h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }

            h /= 3;
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

        int n = hi - lo + 1;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = lo + h; i <= hi; i++) {
                for (int j = i; j >= lo + h && less(a[j], a[j - h], c); j -= h) {
                    swap(a, j, j - h);
                }
            }

            h /= 3;
        }

        assert sorted(a, lo, hi, c);
    }
}
