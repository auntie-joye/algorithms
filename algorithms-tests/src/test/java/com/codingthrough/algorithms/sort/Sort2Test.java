package com.codingthrough.algorithms.sort;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Comparator;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Sort2}.
 */
public class Sort2Test extends SortSupportTest {
    @Test
    public void canSortWhenBothAreNullObjects() {
        final Integer x = null;
        final Integer y = null;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWhenLeftIsNullObject() {
        final Integer x = null;
        final Integer y = 2;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWhenRightIsNullObject() {
        final Integer x = 1;
        final Integer y = null;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(y, x));
    }

    @Test
    public void canSortWhenBothAreTheSameObject() {
        final LocalTime x = LocalTime.now();
        final LocalTime y = x;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWhenBothAreEquals() {
        final Integer x = 2;
        final Integer y = 2;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWhenLeftIsGreater() {
        final Integer x = 3;
        final Integer y = 2;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWhenRightIsGreater() {
        final Integer x = 1;
        final Integer y = 2;

        final Object[] actual = Sort2.sort(x, y);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWithComparatorWhenBothAreNullObjects() {
        final Integer x = null;
        final Integer y = null;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsNullObject() {
        final Integer x = null;
        final Integer y = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWithComparatorWhenRightIsNullObject() {
        final Integer x = 1;
        final Integer y = null;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(y, x));
    }

    @Test
    public void canSortWithComparatorWhenBothAreTheSameObject() {
        final Integer x = 2;
        final Integer y = x;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWithComparatorWhenBothAreEquals() {
        final Integer x = 2;
        final Integer y = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void canSortWithComparatorWhenLeftIsGreater() {
        final Integer x = 3;
        final Integer y = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(y, x));
    }

    @Test
    public void canSortWithComparatorWhenRightIsGreater() {
        final Integer x = 1;
        final Integer y = 2;
        final Comparator<Integer> c = new CustomComparator();

        final Object[] actual = Sort2.sort(x, y, c);
        assertThat(actual, arrayContaining(x, y));
    }

    @Test
    public void throwsWhenComparatorIsNull() {
        final Integer x = 1;
        final Integer y = 2;

        try {
            Sort2.sort(x, y, null);
            fail("Should throw when comparator object is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }
}
