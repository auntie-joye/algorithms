package com.codingthrough.algorithms.search;

import com.codingthrough.algorithms.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.codingthrough.algorithms.adt.ArrayPreconditions.ensureBounds;

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
     * @return index of the element if it's found, otherwise -1
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public static <T> int indexOf(@Nonnull T[] a, @Nullable T e) {
        return indexOf(a, 0, a.length - 1, e);
    }

    /**
     * Finds the element in the array inside bounds, uses <tt>Object.equals()</tt>
     * method for comparison.
     *
     * @param a  the array
     * @param lo the lowest index
     * @param hi the highest index
     * @param e  the element to find
     * @return index of the element if it's found, otherwise -1
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static <T> int indexOf(@Nonnull T[] a, int lo, int hi, @Nullable T e) {
        Preconditions.ensureNotNull(a, "Array [a] should not be null.");
        ensureBounds(a.length, lo, hi);

        int index = -1;
        if (e == null) {
            for (int i = lo; i <= hi; i++) {
                if (a[i] == null) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = lo; i <= hi; i++) {
                if (e.equals(a[i])) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    /**
     * Finds the number of duplicates for the specified element in the array, uses <tt>Object.equals()</tt>
     * method for comparison.
     *
     * @param a the array
     * @param e the element to find duplicates number
     * @return number of duplicates
     * @throws IllegalArgumentException if the specified array is {@code null}
     */
    public static <T> int duplicates(@Nonnull T[] a, @Nullable T e) {
        return duplicates(a, 0, a.length - 1, e);
    }

    /**
     * Finds the number of duplicates for the specified element in the array, uses <tt>Object.equals()</tt>
     * method for comparison.
     *
     * @param a the array
     * @param e the element to find duplicates number
     * @return number of duplicates
     * @throws IllegalArgumentException if the specified array is {@code null}
     * @throws IllegalArgumentException if the specified bounds are outside of array bounds
     */
    public static <T> int duplicates(@Nonnull T[] a, int lo, int hi, @Nullable T e) {
        Preconditions.ensureNotNull(a, "Array [a] should not be null.");
        ensureBounds(a.length, lo, hi);

        int count = 0;
        if (e == null) {
            for (int i = lo; i <= hi; i++) {
                if (a[i] == null) {
                    count++;
                }
            }
        } else {
            for (int i = lo; i <= hi; i++) {
                if (e.equals(a[i])) {
                    count++;
                }
            }
        }

        return count;
    }
}

