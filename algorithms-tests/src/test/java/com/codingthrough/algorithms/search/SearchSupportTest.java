package com.codingthrough.algorithms.search;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link SearchSupport}.
 */
public class SearchSupportTest {
    @Test
    public void throwsWhenCheckForLessNullWithNull() {
        try {
            SearchSupport.less(null, null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckForLessNullWithValue() {
        try {
            SearchSupport.less(null, 3);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckForLessValueWithNull() {
        try {
            SearchSupport.less(3, null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsFalseWhenCheckForLessTheSameReference() {
        final Integer value = 3;

        assertThat(SearchSupport.less(value, value), is(false));
    }

    @Test
    public void returnsFalseWhenCheckForLessEqualsValues() {
        final Integer a = 3;
        final Integer b = 3;

        assertThat(SearchSupport.less(a, b), is(false));
    }

    @Test
    public void returnsFalseWhenCheckForLessGreaterValueWithLessValue() {
        final Integer a = 5;
        final Integer b = 3;

        assertThat(SearchSupport.less(a, b), is(false));
    }

    @Test
    public void returnsTrueWhenCheckForLessLessValueWithGreaterValue() {
        final Integer a = 3;
        final Integer b = 5;

        assertThat(SearchSupport.less(a, b), is(true));
    }

    @Test
    public void throwsWhenCheckForGreaterNullWithNull() {
        try {
            SearchSupport.greater(null, null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckForGreaterNullWithValue() {
        try {
            SearchSupport.greater(null, 3);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckForGreaterValueWithNull() {
        try {
            SearchSupport.greater(3, null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsFalseWhenCheckForGreaterTheSameReference() {
        final Integer value = 3;

        assertThat(SearchSupport.greater(value, value), is(false));
    }

    @Test
    public void returnsFalseWhenCheckForGreaterEqualsValues() {
        final Integer a = 3;
        final Integer b = 3;

        assertThat(SearchSupport.greater(a, b), is(false));
    }

    @Test
    public void returnsFalseWhenCheckForGreaterGreaterValueWithLessValue() {
        final Integer a = 5;
        final Integer b = 3;

        assertThat(SearchSupport.greater(a, b), is(true));
    }

    @Test
    public void returnsTrueWhenCheckForGreaterLessValueWithGreaterValue() {
        final Integer a = 3;
        final Integer b = 5;

        assertThat(SearchSupport.greater(a, b), is(false));
    }

    @Test
    public void throwsWhenCheckNullArrayForSorted() {
        try {
            SearchSupport.sorted(null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsTrueWhenCheckEmptyArrayForSorted() {
        final Integer[] a = new Integer[0];

        assertThat(SearchSupport.sorted(a), is(true));
    }

    @Test
    public void returnsTrueWhenCheckOneElementArrayForSorted() {
        final Integer[] a = new Integer[]{1};

        assertThat(SearchSupport.sorted(a), is(true));
    }

    @Test
    public void returnsTrueWhenCheckTwoElementSortedArrayForSorted() {
        final Integer[] a = new Integer[]{1, 3};

        assertThat(SearchSupport.sorted(a), is(true));
    }

    @Test
    public void returnsFalseWhenCheckTwoElementUnsortedArrayForSorted() {
        final Integer[] a = new Integer[]{3, 1};

        assertThat(SearchSupport.sorted(a), is(false));
    }

    @Test
    public void returnsTrueWhenCheckSortedArrayForSorted() {
        final Integer[] a = new Integer[]{1, 3, 5, 7, 9};

        assertThat(SearchSupport.sorted(a), is(true));
    }

    @Test
    public void returnsFalseWhenCheckUnsortedArrayForSorted() {
        final Integer[] a = new Integer[]{3, 1, 9, 5, 7};

        assertThat(SearchSupport.sorted(a), is(false));
    }

    @Test
    public void throwsWhenCheckNullArrayWithBoundsForSorted() {
        try {
            SearchSupport.sorted(null, 0, 0);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckArrayWithBoundsForSortedAndLowBoundGreaterUpperBound() {
        final Integer[] a = new Integer[]{1, 2, 3};
        try {
            SearchSupport.sorted(a, 2, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckArrayWithBoundsForSortedAndLowBoundLessThanTheFirstArrayIndex() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            SearchSupport.sorted(a, -1, 1);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckArrayWithBoundsForSortedAndUpperBoundGreaterThanArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            SearchSupport.sorted(a, 0, 3);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckArrayWithBoundsForSortedAndUpperBoundEqualsArrayLength() {
        final Integer[] a = new Integer[]{1, 2};
        try {
            SearchSupport.sorted(a, 0, 2);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckEmptyArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[0];

        try {
            SearchSupport.sorted(a, 0, 0);
            fail("Should throw when check for sorted in empty array with bounds.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsTrueWhenCheckOneElementArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[]{4, 3, 1};

        assertThat(SearchSupport.sorted(a, 2, 2), is(true));
    }

    @Test
    public void returnsTrueWhenCheckTwoElementSortedArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[]{3, 2, 1, 4};

        assertThat(SearchSupport.sorted(a, 2, 3), is(true));
    }

    @Test
    public void returnsFalseWhenCheckTwoElementUnsortedArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[]{2, 3, 4, 1};

        assertThat(SearchSupport.sorted(a, 2, 3), is(false));
    }

    @Test
    public void returnsTrueWhenCheckSortedArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[]{2, 1, 5, 7, 9};

        assertThat(SearchSupport.sorted(a, 2, 4), is(true));
    }

    @Test
    public void returnsFalseWhenCheckUnsortedArrayWithBoundsForSorted() {
        final Integer[] a = new Integer[]{1, 2, 9, 5, 7};

        assertThat(SearchSupport.sorted(a, 2, 4), is(false));
    }

    @Test
    public void doesNotThrowWhenCheckForLessBothNullValuesWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.less(null, null, c), is(false));
    }

    @Test
    public void doesNotThrowWhenCheckForLessNullWithValueWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.less(null, 3, c), is(true));
    }

    @Test
    public void doesNotThrowWhenCheckForLessValueWithNullWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.less(3, null, c), is(false));
    }

    @Test
    public void returnsBasedOnComparatorOutputWhenCheckForLessValuesWithComparator() {
        final Comparator<Integer> c = (a, b) -> -1;

        assertThat(SearchSupport.less(5, 2, c), is(true));
    }

    @Test
    public void doesNotThrowWhenCheckForGreaterBothNullValuesWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.greater(null, null, c), is(false));
    }

    @Test
    public void doesNotThrowWhenCheckForGreaterNullWithValueWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.greater(null, 3, c), is(false));
    }

    @Test
    public void doesNotThrowWhenCheckForGreaterValueWithNullWithProperComparator() {
        final Comparator<Integer> c = (a, b) -> {
            if (a == null && b == null) {
                return 0;
            } else if (a == null) {
                return -1;
            } else if (b == null) {
                return +1;
            } else {
                return a.compareTo(b);
            }
        };

        assertThat(SearchSupport.greater(3, null, c), is(true));
    }

    @Test
    public void returnsBasedOnComparatorOutputWhenCheckForGreaterValuesWithComparator() {
        final Comparator<Integer> c = (a, b) -> -1;

        assertThat(SearchSupport.greater(5, 2, c), is(false));
    }

    @Test
    public void throwsWhenCheckNullArrayForSortedWithComparator() {
        final Comparator<Integer> c = (a, b) -> -1;

        try {
            SearchSupport.sorted(null, c);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCheckArrayForSortedWithNullComparator() {
        final Integer[] a = new Integer[0];

        try {
            SearchSupport.sorted(a, null);
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsTrueWhenCheckEmptyArrayForSortedWithComparator() {
        final Integer[] a = new Integer[0];
        final Comparator<Integer> c = (b, d) -> -1;

        assertThat(SearchSupport.sorted(a, c), is(true));
    }

    @Test
    public void returnsTrueWhenCheckArrayForSortedWithComparator() {
        final Integer[] a = new Integer[]{4, 2, 3, 5};
        final Comparator<Integer> c = (b, d) -> 1;

        assertThat(SearchSupport.sorted(a, c), is(true));
    }

    @Test
    public void returnsFalseWhenCheckArrayForSortedWithComparator() {
        final Integer[] a = new Integer[]{4, 2, 3, 5};
        final Comparator<Integer> c = (b, d) -> -1;

        assertThat(SearchSupport.sorted(a, c), is(false));
    }
}
