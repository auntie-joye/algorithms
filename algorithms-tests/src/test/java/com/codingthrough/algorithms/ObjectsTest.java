package com.codingthrough.algorithms;

import org.junit.Test;

import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Objects}.
 */
public class ObjectsTest {
    @Test
    public void successfulParameterCheckOnNullWhenObjectIsNotNull() {
        final Integer obj = 1;

        Objects.requireNotNull(obj);
    }

    @Test
    public void failedParameterCheckOnNullWhenObjectIsNull() {
        final Integer obj = null;

        try {
            Objects.requireNotNull(obj);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String message = "Should be not null.";

        Objects.requireNotNull(obj, message);
    }

    @Test
    public void failedParameterCheckOnNullWithMessageWhenObjectIsNull() {
        final Integer obj = null;
        final String message = "Should be not null.";

        try {
            Objects.requireNotNull(obj, message);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            assertThat(e.getMessage(), is(message));
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageSupplierWhenObjectIsNotNull() {
        final Integer obj = 1;
        final Supplier<String> messageSupplier = () -> "Should not be null.";

        Objects.requireNotNull(obj, messageSupplier);
    }

    @Test
    public void failedParameterCheckOnNullWithMessageSupplierWhenObjectIsNull() {
        final Integer obj = null;
        final Supplier<String> messageSupplier = () -> "Should not be null.";

        try {
            Objects.requireNotNull(obj, messageSupplier);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

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

        assertThat(Objects.equals(obj, null), is(false));
    }

    @Test
    public void equalsReturnsFalseWhenTheRightReferenceIsNull() {
        final Integer obj = 2;

        assertThat(Objects.equals(null, obj), is(false));
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
