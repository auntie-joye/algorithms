package com.codingthrough.algorithms.sort;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Comparator;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Sort3}.
 */
public class Sort3Test extends SortSupportTest {
    @Test
    public void canSortWhenAllAreNullObjects() {
        final Integer x = null;
        final Integer y = null;
        final Integer z = null;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWhenLeftIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = null;
        final Integer y = 3;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, z, y));
    }

    @Test
    public void canSortWhenLeftIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = null;
        final Integer y = 1;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWhenRightIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = 3;
        final Integer y = 2;
        final Integer z = null;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(z, y, x));
    }

    @Test
    public void canSortWhenRightIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 2;
        final Integer z = null;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(z, x, y));
    }

    @Test
    public void canSortWhenMiddleIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = 3;
        final Integer y = null;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(y, z, x));
    }

    @Test
    public void canSortWhenMiddleIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = null;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(y, x, z));
    }

    @Test
    public void canSortWhenAllAreTheSameObject() {
        final LocalTime x = LocalTime.now();
        final LocalTime y = x;
        final LocalTime z = x;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWhenAllAreEquals() {
        final Integer x = 2;
        final Integer y = 2;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWhenLeftIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 3;
        final Integer y = 1;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(y, z, x));
    }

    @Test
    public void canSortWhenLeftIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 3;
        final Integer y = 2;
        final Integer z = 1;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(z, y, x));
    }

    @Test
    public void canSortWhenMiddleIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 3;
        final Integer z = 2;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, z, y));
    }

    @Test
    public void canSortWhenMiddleIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 2;
        final Integer y = 3;
        final Integer z = 1;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(z, x, y));
    }

    @Test
    public void canSortWhenRightIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 2;
        final Integer z = 3;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWhenRightIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 2;
        final Integer y = 1;
        final Integer z = 3;

        final Object[] actual = Sort3.sort(x, y, z);
        assertThat(actual, arrayContaining(y, x, z));
    }

    @Test
    public void canSortWithComparatorWhenAllAreNullObjects() {
        final Integer x = null;
        final Integer y = null;
        final Integer z = null;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = null;
        final Integer y = 3;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, z, y));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = null;
        final Integer y = 1;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWithComparatorWhenRightIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = 3;
        final Integer y = 2;
        final Integer z = null;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(z, y, x));
    }

    @Test
    public void canSortWithComparatorWhenRightIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 2;
        final Integer z = null;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(z, x, y));
    }

    @Test
    public void canSortWithComparatorWhenMiddleIsNullObjectAndOtherAreInDescendingOrder() {
        final Integer x = 3;
        final Integer y = null;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(y, z, x));
    }

    @Test
    public void canSortWithComparatorWhenMiddleIsNullObjectAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = null;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(y, x, z));
    }

    @Test
    public void canSortWithComparatorWhenAllAreTheSameObject() {
        final Integer x = 2;
        final Integer y = x;
        final Integer z = x;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWithComparatorWhenAllAreEquals() {
        final Integer x = 2;
        final Integer y = 2;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 3;
        final Integer y = 1;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(y, z, x));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 3;
        final Integer y = 2;
        final Integer z = 1;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(z, y, x));
    }

    @Test
    public void canSortWithComparatorWhenMiddleIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 3;
        final Integer z = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, z, y));
    }

    @Test
    public void canSortWithComparatorWhenMiddleIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 2;
        final Integer y = 3;
        final Integer z = 1;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(z, x, y));
    }

    @Test
    public void canSortWithComparatorWhenRightIsTheBiggestAndOtherAreInAscendingOrder() {
        final Integer x = 1;
        final Integer y = 2;
        final Integer z = 3;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(x, y, z));
    }

    @Test
    public void canSortWithComparatorWhenRightIsTheBiggestAndOtherAreDescendingOrder() {
        final Integer x = 2;
        final Integer y = 1;
        final Integer z = 3;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort3.sort(x, y, z, c);
        assertThat(actual, arrayContaining(y, x, z));
    }

    @Test
    public void throwsWhenComparatorIsNull() {
        final Integer x = 2;
        final Integer y = 1;
        final Integer z = 3;

        try {
            Sort3.sort(x, y, z, null);
            fail("Should throw when comparator object is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }
}
