package com.codingthrough.algorithms.search;

import java.util.Comparator;

/**
 * The <tt>BinarySearch</tt> provides a static method to search the element in the sorted array
 * using binary search algorithm.
 * <p>
 * For additional documentation,
 * see <a href="https://en.wikipedia.org/wiki/Binary_search_algorithm">Wikipedia article - Binary Search</a>.
 * </p>
 */
public class BinarySearch extends SearchSupport {
    /**
     * This class should not be instantiated.
     */
    private BinarySearch() {
    }

    /**
     * Finds the element in the sorted array.
     *
     * @param a the sorted array
     * @param e the element to find
     */
    public static <T extends Comparable<T>> int indexOf(T[] a, T e) {
        return indexOf(a, 0, a.length - 1, e);
    }

    /**
     * Finds the element in the sorted array inside bounds.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     */
    public static <T extends Comparable<T>> int indexOf(T[] a, int lo, int hi, T e) {
        checkBounds(a.length, lo, hi);

        assert sorted(a, lo, hi);

        return indexOfRecursive(a, lo, hi, e);
    }

    /**
     * Finds the element in the sorted array inside bounds.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     */
    private static <T extends Comparable<T>> int indexOfRecursive(T[] a, int lo, int hi, T e) {
        if (lo >= hi) {
            return a[lo].compareTo(e) == 0 ? lo : -1;
        }

        int mid = lo + (hi - lo) / 2;

        return less(a[mid], e)
                ? indexOfRecursive(a, mid + 1, hi, e)
                : indexOfRecursive(a, mid, hi, e);
    }

    /**
     * Finds the element in the sorted array.
     *
     * @param a the sorted array
     * @param e the element to find
     * @param c the comparator specifying the order
     */
    public static <T> int indexOf(T[] a, T e, Comparator<T> c) {
        return indexOf(a, 0, a.length - 1, e, c);
    }

    /**
     * Finds the element in the sorted array inside bounds.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @param c  the comparator specifying the order
     */
    public static <T> int indexOf(T[] a, int lo, int hi, T e, Comparator<T> c) {
        checkBounds(a.length, lo, hi);

        assert sorted(a, lo, hi, c);

        return indexOfRecursive(a, lo, hi, e, c);
    }

    /**
     * Finds the element in the sorted array inside bounds.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @param c  the comparator specifying the order
     */
    private static <T> int indexOfRecursive(T[] a, int lo, int hi, T e, Comparator<T> c) {
        if (lo >= hi) {
            return c.compare(a[lo], e) == 0 ? lo : -1;
        }

        int mid = lo + (hi - lo) / 2;

        return less(a[mid], e, c)
                ? indexOfRecursive(a, mid + 1, hi, e, c)
                : indexOfRecursive(a, mid, hi, e, c);
    }
}

