package com.codingthrough.algorithms.search;

import java.util.Comparator;

/**
 * The <tt>BinarySearch</tt> provides a static method to search the element in the sorted array
 * using binary search algorithm.
 * <p>
 * For additional information,
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
     * Finds the element in the sorted array, uses <tt>Comparable.compareTo()</tt>
     * method for comparison.
     *
     * @param a the sorted array
     * @param e the element to find
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T extends Comparable<T>> int rank(T[] a, T e) {
        return rank(a, 0, a.length - 1, e);
    }

    /**
     * Finds the element in the sorted array inside bounds, uses <tt>Comparable.compareTo()</tt>
     * method for comparison.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T extends Comparable<T>> int rank(T[] a, int lo, int hi, T e) {
        checkBounds(a.length, lo, hi);

        assert sorted(a, lo, hi);
        return rankRecursive(a, lo, hi, e);
    }

    /**
     * Finds the element in the sorted array inside bounds, uses <tt>Comparable.compareTo()</tt>
     * method for comparison.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @return index of the element if it's found, otherwise -1.
     */
    private static <T extends Comparable<T>> int rankRecursive(T[] a, int lo, int hi, T e) {
        if (lo >= hi) {
            return a[lo].compareTo(e) == 0 ? lo : -1;
        }

        int mid = lo + (hi - lo) / 2;

        return less(a[mid], e)
                ? rankRecursive(a, mid + 1, hi, e)
                : rankRecursive(a, mid, hi, e);
    }

    /**
     * Finds the element in the sorted array, uses <tt>Comparator.compare()</tt>
     * method for comparison.
     *
     * @param a the sorted array
     * @param e the element to find
     * @param c the comparator specifying the order
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T> int rank(T[] a, T e, Comparator<T> c) {
        return rank(a, 0, a.length - 1, e, c);
    }

    /**
     * Finds the element in the sorted array inside bounds, uses <tt>Comparator.compare()</tt>
     * method for comparison.
     *
     * @param a  the sorted array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @param c  the comparator specifying the order
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T> int rank(T[] a, int lo, int hi, T e, Comparator<T> c) {
        checkBounds(a.length, lo, hi);

        assert sorted(a, lo, hi, c);

        int rank = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = c.compare(a[mid], e);

            if (cmp < 0) {
                lo = mid + 1;
            } else if (cmp > 0) {
                hi = mid - 1;
            } else {
                rank = mid;
            }
        }

        return rank;
    }
}

