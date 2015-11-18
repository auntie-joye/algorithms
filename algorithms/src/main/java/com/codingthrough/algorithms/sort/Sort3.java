package com.codingthrough.algorithms.sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Comparator;

import static com.codingthrough.algorithms.Preconditions.ensureNotNull;

/**
 * Sorts three specified objects and returns them in the ascending order in the output array.
 * Considers {@link null} object is less than not {@link null} object.
 */
public class Sort3 extends SortSupport {
    @SuppressWarnings("unchecked")
    public static Comparable[] sort(@Nullable Comparable x, @Nullable Comparable y, @Nullable Comparable z) {
        Comparable[] a = new Comparable[]{x, y, z};

        if (a[0] != null && a[1] != null && a[0].compareTo(a[1]) > 0) {
            swap(a, 0, 1);
        } else if (a[0] != null && a[1] == null) {
            swap(a, 0, 1);
        }

        if (a[1] != null && a[2] != null && a[1].compareTo(a[2]) > 0) {
            swap(a, 1, 2);
        } else if (a[1] != null && a[2] == null) {
            swap(a, 1, 2);
        }

        if (a[0] != null && a[1] != null && a[0].compareTo(a[1]) > 0) {
            swap(a, 0, 1);
        } else if (a[0] != null && a[1] == null) {
            swap(a, 0, 1);
        }

        return a;
    }

    @SuppressWarnings("unchecked")
    public static Object[] sort(Object x, Object y, Object z, @Nonnull Comparator c) {
        ensureNotNull(c);

        Object[] a = new Object[]{x, y, z};

        if (c.compare(a[0], a[1]) > 0) {
            swap(a, 0, 1);
        }

        if (c.compare(a[1], a[2]) > 0) {
            swap(a, 1, 2);
        }

        if (c.compare(a[0], a[1]) > 0) {
            swap(a, 0, 1);
        }

        return a;
    }
}
