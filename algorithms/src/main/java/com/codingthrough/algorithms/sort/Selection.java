package com.codingthrough.algorithms.sort;

import java.util.Comparator;

/**
 * The <tt>Selection</tt> provides a number of static methods to sort an array
 * using selection sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Selection_sort">Wikipedia article - Selection Sort</a>.
 * </p>
 */
public class Selection extends SortSupport {
    /**
     * This class should not be instantiated.
     */
    private Selection() {
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

        for (int i = lo; i < hi; i++) {
            int min = i;
            for (int j = i + 1; j <= hi; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            swap(a, min, i);
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

        for (int i = lo; i < hi; i++) {
            int min = i;
            for (int j = i + 1; j <= hi; j++) {
                if (less(a[j], a[min], c)) {
                    min = j;
                }
            }

            swap(a, min, i);
        }

        assert sorted(a, lo, hi, c);
    }
}
