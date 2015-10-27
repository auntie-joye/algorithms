package com.codingthrough.algorithms.search;

/**
 * The <tt>LinearSearch</tt> provides a static method to search the element in the array
 * using linear search algorithm.
 * <p>
 * For additional documentation,
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
     * Finds the element in the array.
     *
     * @param a the array
     * @param e the element to find
     */
    public static <T> int indexOf(T[] a, T e) {
        return indexOf(a, 0, a.length - 1, e);
    }

    /**
     * Finds the element in the array inside bounds.
     *
     * @param a  the array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     */
    public static <T> int indexOf(T[] a, int lo, int hi, T e) {
        checkBounds(a.length, lo, hi);

        int index = -1;
        for (int i = lo; i <= hi; i++) {
            if (a[i].equals(e)) {
                index = i;
                break;
            }
        }

        return index;
    }
}

