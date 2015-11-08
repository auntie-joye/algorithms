package com.codingthrough.algorithms.search;

/**
 * The <tt>LinearSearch</tt> provides a static method to search the element in the array
 * using linear search algorithm.
 * <p>
 * For additional information,
 * see <a href="https://en.wikipedia.org/wiki/Linear_search">Wikipedia article - Linear Search</a>.
 * </p>
 */
public class LinearSearch extends SearchSupport {
    /**
     * This class should not be instantiated.
     */
    private LinearSearch() {
    }

    /**
     * Finds the element in the array, uses <tt>Object.equals()</tt>
     * method for comparison.
     *
     * @param a the array
     * @param e the element to find
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T> int rank(T[] a, T e) {
        return rank(a, 0, a.length - 1, e);
    }

    /**
     * Finds the element in the array inside bounds, uses <tt>Object.equals()</tt>
     * method for comparison.
     *
     * @param a  the array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @return index of the element if it's found, otherwise -1.
     */
    public static <T> int rank(T[] a, int lo, int hi, T e) {
        checkBounds(a.length, lo, hi);

        int rank = -1;
        for (int i = lo; i <= hi; i++) {
            if (a[i].equals(e)) {
                rank = i;
                break;
            }
        }

        return rank;
    }
}

