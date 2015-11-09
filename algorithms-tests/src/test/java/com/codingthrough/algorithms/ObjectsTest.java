package com.codingthrough.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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
}
