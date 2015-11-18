package com.codingthrough.algorithms.sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;

/**
 * Sorts two specified objects and returns them in the ascending order in the output array.
 * Considers {@link null} object is less than not {@link null} object.
 */
public class Sort2 extends SortSupport {
    @SuppressWarnings("unchecked")
    public static Comparable[] sort(@Nullable Comparable x, @Nullable Comparable y) {
        Comparable[] a = new Comparable[]{x, y};

        if (a[0] != null && a[1] != null && a[0].compareTo(a[1]) > 1) {
            swap(a, 0, 1);
        }

        if (a[1] == null) {
            swap(a, 0, 1);
        }

        return a;
    }

    @SuppressWarnings("unchecked")
    public static Object[] sort(Object x, Object y, @Nonnull Comparator c) {
        ensureNotNull(c);

        Object[] a = new Object[]{x, y};

        if (c.compare(a[0], a[1]) > 0) {
            swap(a, 0, 1);
        }

        return a;
    }
}
