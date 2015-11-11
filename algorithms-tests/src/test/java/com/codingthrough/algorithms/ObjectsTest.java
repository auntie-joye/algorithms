package com.codingthrough.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for {@link Objects}.
 */
public class ObjectsTest {
    @Test
    public void returnsTrueWhenIsNullTakesNullArgument() {
        final Integer obj = null;

        assertThat(Objects.isNull(obj), is(true));
    }

    @Test
    public void returnsFalseWhenIsNullTakesNotNullArgument() {
        final Integer obj = 1;

        assertThat(Objects.isNull(obj), is(false));
    }

    @Test
    public void returnsFalseWhenIsNotNullTakesNullArgument() {
        final Integer obj = null;

        assertThat(Objects.isNotNull(obj), is(false));
    }

    @Test
    public void returnsTrueWhenIsNotNullTakesNotNullArgument() {
        final Integer obj = 1;

        assertThat(Objects.isNotNull(obj), is(true));
    }

    @Test
    public void equalsReturnsTrueWhenTheSameReferences() {
        final Integer obj = 2;

        assertThat(Objects.equals(obj, obj), is(true));
    }

    @Test
    public void equalsReturnsFalseWhenTheLeftReferenceIsNull() {
        final Integer obj = 2;

        assertThat(Objects.equals(null, obj), is(false));
    }

    @Test
    public void equalsReturnsFalseWhenTheRightReferenceIsNull() {
        final Integer obj = 2;

        assertThat(Objects.equals(obj, null), is(false));
    }

    @Test
    public void equalsReturnsTrueWhenBothReferencesAreNull() {
        assertThat(Objects.equals(null, null), is(true));
    }

    @Test
    public void equalsReturnsTrueWhenDifferentReferencesAndObjectsAreEqual() {
        final Integer a = 2;
        final Integer b = 2;

        assertThat(Objects.equals(a, b), is(true));
    }

    @Test
    public void equalsReturnsFalseWhenDifferentReferencesAndObjectsAreNotEqual() {
        final Integer a = 2;
        final Integer b = 21;

        assertThat(Objects.equals(a, b), is(false));
    }

    @Test
    public void hashcodeReturnsDifferentValuesForDifferentListOfObjects() {
        final int h1 = Objects.hashCode(1, "2", new Object());
        final int h2 = Objects.hashCode(11, "22", new Object());

        assertThat(h1, is(not(h2)));
    }

    @Test
    public void hashcodeReturnsDifferentValuesForTheSameListOfObjectsInDifferentOrder() {
        final int h1 = Objects.hashCode(1, "2", new Object());
        final int h2 = Objects.hashCode("2", new Object(), 1);

        assertThat(h1, is(not(h2)));
    }

    @Test
    public void hashcodeReturnsEqualValuesForTheSameListOfObjectsInTheSameOrder() {
        final int h1 = Objects.hashCode(1, "2", new Object());
        final int h2 = Objects.hashCode(1, "2", new Object());

        assertThat(h1, is(h2));
    }
}
