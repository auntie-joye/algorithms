package com.codingthrough.algorithms.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * The <tt>MergeBU</tt> provides a number of static methods to sort an array
 * using bottom-up merge sort algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Merge_sort">Wikipedia article - Merge Sort</a>.
 * </p>
 * For an top-down version, see {@link Merge}.
 */
public class MergeBU extends SortSupport {
    /**
     * This class should not be instantiated.
     */
    private MergeBU() {
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
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        checkBounds(a.length, lo, hi);

        T[] aux = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        sort(a, aux, lo, hi);
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
        int n = hi - lo + 1;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = lo; i < n; i += 2 * sz) {
                merge(a, aux, i, i + sz - 1, Math.min(n, i + 2 * sz - 1));
            }
        }
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
    @SuppressWarnings("unchecked")
    public static <T> void sort(T[] a, int lo, int hi, Comparator<T> c) {
        checkBounds(a.length, lo, hi);

        T[] aux = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
        sort(a, aux, lo, hi, c);
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
        int n = hi - lo + 1;
        for (int sz = 1; sz < n; sz *= 2) {
            for (int i = lo; i < n; i += 2 * sz) {
                merge(a, aux, i, i + sz - 1, Math.min(n, i + 2 * sz - 1), c);
            }
        }
    }


    /**
     * Merges a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi].
     */
    private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        assert sorted(a, lo, mid);
        assert sorted(a, mid + 1, hi);

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

        assert sorted(a, lo, hi);
    }

    /**
     * Merges a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi].
     */
    private static <T> void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<T> c) {
        assert sorted(a, lo, mid, c);
        assert sorted(a, mid + 1, hi, c);

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

        assert sorted(a, lo, hi, c);
    }
}
