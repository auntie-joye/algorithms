package com.codingthrough.algorithms.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The <tt>Merge</tt> provides a number of static methods to sort an array
 * using merge sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Merge_sort">Wikipedia article - Merge Sort</a>.
 * </p>
 */
public class Merge {
    /**
     * This class should not be instantiated.
     */
    private Merge() {
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

        T[] aux = Arrays.copyOf(a, a.length);
        sort(a, aux, lo, hi);

        assert sorted(a, lo, hi);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the natural order.
     *
     * @param a   the array to be sorted
     * @param aux the auxiliary array for merge operation
     * @param lo  the lowest index
     * @param hi  the highest index
     */
    private static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
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

        T[] aux = Arrays.copyOf(a, a.length);
        sort(a, aux, lo, hi, c);

        assert sorted(a, lo, hi, c);
    }

    /**
     * Rearranges the array inside bounds in ascending order using the natural order.
     *
     * @param a   the array to be sorted
     * @param aux the auxiliary array for merge operation
     * @param lo  the lowest index
     * @param hi  the highest index
     * @param c   the comparator specifying the order
     */
    private static <T> void sort(T[] a, T[] aux, int lo, int hi, Comparator<T> c) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, c);
        sort(a, aux, mid + 1, hi, c);
        merge(a, aux, lo, mid, hi, c);
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
     * Merges a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi].
     */
    private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int j = lo, k = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (j > mid) {
                a[i] = aux[k++];
            } else if (k > hi) {
                a[i] = aux[j++];
            } else if (less(aux[j], aux[k])) {
                a[i] = aux[j++];
            } else {
                a[i] = aux[k++];
            }
        }
    }

    /**
     * Merges a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi].
     */
    private static <T> void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<T> c) {
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        int j = lo, k = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (j > mid) {
                a[i] = aux[k++];
            } else if (k > hi) {
                a[i] = aux[j++];
            } else if (less(aux[j], aux[k], c)) {
                a[i] = aux[j++];
            } else {
                a[i] = aux[k++];
            }
        }
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
