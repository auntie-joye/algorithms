package com.codingthrough.algorithms.sort;

import java.util.Comparator;

/**
 * The <tt>Bubble</tt> provides a number of static methods to sort an array
 * using bubble sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia article - Bubble Sort</a>.
 * </p>
 */
public class Bubble extends SortSupport {
    /**
     * This class should not be instantiated.
     */
    private Bubble() {
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

        int k = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = lo; i < hi - k; i++) {
                if (less(a[i + 1], a[i])) {
                    swap(a, i + 1, i);
                    sorted = false;
                }
            }
            k++;
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

        int k = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = lo; i < hi - k; i++) {
                if (less(a[i + 1], a[i], c)) {
                    swap(a, i + 1, i);
                    sorted = false;
                }
            }
            k++;
        }

        assert sorted(a, lo, hi, c);
    }
}
