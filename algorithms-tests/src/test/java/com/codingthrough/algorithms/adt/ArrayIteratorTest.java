package com.codingthrough.algorithms.adt;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link ArrayIterator}.
 */
public class ArrayIteratorTest {
    @Test
    public void throwsWhenCreateWithNullArray() {
        final Integer[] a = null;

        try {
            new ArrayIterator<>(a);
            fail("Should throw when create iterator with null array.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void shouldNotHaveNextForEmptyArray() {
        final Integer[] a = new Integer[0];

        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void throwsWhenCallNextForEmptyArray() {
        final Integer[] a = new Integer[0];
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);

        try {
            iterator.next();
            fail("Should throw when call next for empty array.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canHaveNextForNotEmptyArray() {
        final Integer[] a = new Integer[]{1};

        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void canReturnNextForNotEmptyArray() {
        final Integer item = 1;
        final Integer[] a = new Integer[]{item};

        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);
        assertThat(iterator.next(), is(item));
    }

    @Test
    public void shouldNotHaveNextAfterIteratingLastElement() {
        final Integer[] a = new Integer[]{1};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);
        iterator.next();

        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void throwsWhenCallNextAfterIteratingLastElement() {
        final Integer[] a = new Integer[0];
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);
        iterator.next();

        try {
            iterator.next();
            fail("Should throw when call next after iterating last element.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canIterateOverArrayFromStartTillEnd() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void throwsWhenCreateWithNullArrayAndIndex() {
        final Integer[] a = null;
        final int index = 0;

        try {
            new ArrayIterator<>(a, index);
            fail("Should throw when create iterator with null array and some index.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCreateWithSomeArrayAndNegativeIndex() {
        final Integer[] a = new Integer[]{1, 2};
        final int index = -1;

        try {
            new ArrayIterator<>(a, index);
            fail("Should throw when create iterator with some array and negative index.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCreateWithSomeArrayAndLargerIndex() {
        final Integer[] a = new Integer[]{1, 2};
        final int index = 2;

        try {
            new ArrayIterator<>(a, index);
            fail("Should throw when create iterator with some array and larger index.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canIterateFromZeroIndex() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 0);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateFromMiddleIndex() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 1);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateFromLastIndex() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 2);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void throwsWhenCreateWithNullArrayAndIndexBounds() {
        final Integer[] a = null;
        final int start = 0;
        final int end = 0;

        try {
            new ArrayIterator<>(a, start, end);
            fail("Should throw when create iterator with null array and some bounds.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCreateWithSomeArrayAndNegativeStart() {
        final Integer[] a = new Integer[]{1, 2};
        final int start = -1;
        final int end = 0;

        try {
            new ArrayIterator<>(a, start, end);
            fail("Should throw when create iterator with some array and negative start.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCreateWithSomeArrayAndLargerEnd() {
        final Integer[] a = new Integer[]{1, 2};
        final int start = 0;
        final int end = 2;

        try {
            new ArrayIterator<>(a, start, end);
            fail("Should throw when create iterator with some array and larger end.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCreateWithSomeArrayAndInvalidRange() {
        final Integer[] a = new Integer[]{1, 2};
        final int start = 1;
        final int end = 0;

        try {
            new ArrayIterator<>(a, start, end);
            fail("Should throw when create iterator with some array and invalid range.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canIterateFromZeroIndexTillEndOFTheArray() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 0, 2);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateFromZeroIndexTillMiddleOFTheArray() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 0, 1);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateFromMiddleIndexTillEndOFTheArray() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 1, 2);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateOverOnlyFirstArrayElement() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 0, 0);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateOverOnlyRandomArrayElement() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 1, 1);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void canIterateOverOnlyLastArrayElement() {
        final Integer[] a = new Integer[]{1, 2, 3};
        final ArrayIterator<Integer> iterator = new ArrayIterator<>(a, 2, 2);

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }
}
