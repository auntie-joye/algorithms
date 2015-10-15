package com.codingthrough.algorithms.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The <tt>Selection</tt> provides a number of static methods to sort an array
 * using selection sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Selection_sort">Wikipedia article - Selection Sort</a>.
 * </p>
 */
public class Selection {
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
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the natural order.
     *
     * @param a  the array to be sorted
     * @param lo the lowest bound to be sorted
     * @param hi the highest bound to be sorted
     */
    public static void sort(Comparable[] a, int lo, int hi) {
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
    public static void sort(Object[] a, Comparator c) {
        sort(a, 0, a.length - 1, c);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the comparator.
     *
     * @param a  the array to be sorted
     * @param lo the lowest bound to be sorted
     * @param hi the highest bound to be sorted
     * @param c  the comparator specifying the order
     */
    public static void sort(Object[] a, int lo, int hi, Comparator c) {
        checkBounds(a.length, lo, hi);

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min], c)) {
                    min = j;
                }
            }

            swap(a, min, i);
        }

        assert sorted(a, lo, hi, c);
    }

    /**
     * @return true if {@param a} is less than {@param b}.
     */
    @SuppressWarnings("unchecked")
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * @return true if {@param a} is less than {@param b} using comparator {@param c}.
     */
    @SuppressWarnings("unchecked")
    private static boolean less(Object a, Object b, Comparator c) {
        return c.compare(a, b) < 0;
    }

    /**
     * Swaps item with index {@param a} and the item with index {@param b}.
     */
    private static void swap(Object[] array, int a, int b) {
        final Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * @return true if {@param a} array is sorted, otherwise false.
     */
    public static boolean sorted(Comparable[] a) {
        return sorted(a, 0, a.length - 1);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false.
     */
    public static boolean sorted(Comparable[] a, int lo, int hi) {
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
    public static boolean sorted(Object[] a, Comparator c) {
        return sorted(a, 0, a.length - 1, c);
    }

    /**
     * @return true if {@param a} array inside bounds is sorted, otherwise false.
     */
    public static boolean sorted(Object[] a, int lo, int hi, Comparator c) {
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
     * @param lo     the lowest bound to be sorted
     * @param hi     the highest bound to be sorted
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

    public static void main(String[] args) {
        final Integer[] array = {4, 6, 2, 3, 1};
        Selection.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(sorted(array));
    }
}
