package com.codingthrough.algorithms.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link LinearSearch}.
 */
public class LinearSearchTest {
    @Test
    public void throwsWhenFindIndexInNullArray() {
        try {
            LinearSearch.indexOf(null, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void failsWhenFindIndexInEmptyArray() {
        final Integer[] a = new Integer[0];

        assertThat(LinearSearch.indexOf(a, 2), is(-1));
    }

    @Test
    public void failsWhenFindIndexInArrayWithNoSuchElement() {
        final Integer[] a = new Integer[]{1, 3, 4, 5};

        assertThat(LinearSearch.indexOf(a, 2), is(-1));
    }

    @Test
    public void failsWhenFindIndexInArrayWithNoSuchElementAndNullValues() {
        final Integer[] a = new Integer[]{1, null, 4, null};

        assertThat(LinearSearch.indexOf(a, 2), is(-1));
    }

    @Test
    public void canFindIndexOfNullElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, null), is(2));
    }

    @Test
    public void canFindIndexOfFirstElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 1), is(0));
    }

    @Test
    public void canFindIndexOfLastElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 5), is(3));
    }

    @Test
    public void canFindIndexOfRandomElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 3), is(1));
    }

    @Test
    public void canFindFirstIndexOfElementWithRepetitions() {
        final Integer[] a = new Integer[]{1, 3, 4, 3};

        assertThat(LinearSearch.indexOf(a, 3), is(1));
    }

    @Test
    public void throwsWhenFindIndexInNullArrayWithBounds() {
        try {
            LinearSearch.indexOf(null, 0, 0, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenFindIndexInEmptyArrayWithBounds() {
        final Integer[] a = new Integer[0];

        try {
            LinearSearch.indexOf(a, 0, 0, 2);
            fail("Should throw when call indexOf() on empty array with bounds.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void failsWhenFindIndexInArrayWithBoundsWithNoSuchElement() {
        final Integer[] a = new Integer[]{1, 3, 4, 5};

        assertThat(LinearSearch.indexOf(a, 1, 3, 1), is(-1));
    }

    @Test
    public void failsWhenFindIndexInArrayWithBoundsWithNoSuchElementAndNullValues() {
        final Integer[] a = new Integer[]{1, null, 4, null};

        assertThat(LinearSearch.indexOf(a, 1, 3, 1), is(-1));
    }

    @Test
    public void canFindIndexOfNullElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 1, 2, null), is(2));
    }

    @Test
    public void canFindIndexOfFirstElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 1, 2, 3), is(1));
    }

    @Test
    public void canFindIndexOfLastElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.indexOf(a, 1, 3, 5), is(3));
    }

    @Test
    public void canFindIndexOfRandomElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, 4, null, 5};

        assertThat(LinearSearch.indexOf(a, 1, 3, 4), is(2));
    }

    @Test
    public void canFindFirstIndexOfElementWithRepetitionsInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 2, 3, 4, 3, 7, 6};

        assertThat(LinearSearch.indexOf(a, 1, 4, 3), is(2));
    }

    @Test
    public void throwsWhenFindIndexInArrayWithBoundsAndLowBoundGreaterUpperBound() {
        final Integer[] a = new Integer[]{1, 2, 3};
        try {
            LinearSearch.indexOf(a, 2, 1, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenFindIndexInArrayWithBoundsAndLowBoundLessThanTheFirstArrayIndex() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.indexOf(a, -1, 1, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenFindIndexInArrayWithBoundsAndUpperBoundGreaterThanArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.indexOf(a, 0, 3, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenFindIndexInArrayWithBoundsAndUpperBoundEqualsArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.indexOf(a, 0, 2, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCountDuplicatesInNullArray() {
        try {
            LinearSearch.duplicates(null, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void failsWhenCountDuplicatesInEmptyArray() {
        final Integer[] a = new Integer[0];

        assertThat(LinearSearch.duplicates(a, 2), is(0));
    }

    @Test
    public void failsWhenCountDuplicatesInArrayWithNoSuchElement() {
        final Integer[] a = new Integer[]{1, 3, 4, 5};

        assertThat(LinearSearch.duplicates(a, 2), is(0));
    }

    @Test
    public void failsWhenCountDuplicatesInArrayWithNoSuchElementAndNullValues() {
        final Integer[] a = new Integer[]{1, null, 4, null};

        assertThat(LinearSearch.duplicates(a, 2), is(0));
    }

    @Test
    public void canCountDuplicatesOfNullElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, null), is(1));
    }

    @Test
    public void canCountDuplicatesOfFirstElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, 1), is(1));
    }

    @Test
    public void canCountDuplicatesOfLastElement() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, 5), is(1));
    }

    @Test
    public void canCountDuplicatesOfRandomElement() {
        final Integer[] a = new Integer[]{1, 3, null, 3, 5};

        assertThat(LinearSearch.duplicates(a, 3), is(2));
    }

    @Test
    public void throwsWhenCountDuplicatesInNullArrayWithBounds() {
        try {
            LinearSearch.duplicates(null, 0, 0, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCountDuplicatesInEmptyArrayWithBounds() {
        final Integer[] a = new Integer[0];

        try {
            LinearSearch.duplicates(a, 0, 0, 2);
            fail("Should throw when call duplicates() on empty array with bounds.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void failsWhenCountDuplicatesInArrayWithBoundsWithNoSuchElement() {
        final Integer[] a = new Integer[]{1, 3, 4, 5};

        assertThat(LinearSearch.duplicates(a, 1, 3, 1), is(0));
    }

    @Test
    public void failsWhenCountDuplicatesInArrayWithBoundsWithNoSuchElementAndNullValues() {
        final Integer[] a = new Integer[]{1, null, 4, null};

        assertThat(LinearSearch.duplicates(a, 1, 3, 1), is(0));
    }

    @Test
    public void canCountDuplicatesOfNullElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, 1, 2, null), is(1));
    }

    @Test
    public void canCountDuplicatesOfFirstElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, 1, 2, 3), is(1));
    }

    @Test
    public void canCountDuplicatesOfLastElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, null, 5};

        assertThat(LinearSearch.duplicates(a, 1, 3, 5), is(1));
    }

    @Test
    public void canCountDuplicatesOfRandomElementInArrayWithBounds() {
        final Integer[] a = new Integer[]{1, 3, 4, 3, 5};

        assertThat(LinearSearch.duplicates(a, 1, 3, 3), is(2));
    }

    @Test
    public void throwsWhenCountDuplicatesInArrayWithBoundsAndLowBoundGreaterUpperBound() {
        final Integer[] a = new Integer[]{1, 2, 3};
        try {
            LinearSearch.duplicates(a, 2, 1, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCountDuplicatesInArrayWithBoundsAndLowBoundLessThanTheFirstArrayIndex() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.duplicates(a, -1, 1, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCountDuplicatesInArrayWithBoundsAndUpperBoundGreaterThanArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.duplicates(a, 0, 3, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCountDuplicatesInArrayWithBoundsAndUpperBoundEqualsArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            LinearSearch.duplicates(a, 0, 2, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }
}
