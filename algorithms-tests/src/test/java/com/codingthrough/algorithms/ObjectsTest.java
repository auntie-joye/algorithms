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
    public void successfulParameterCheckOnNotNullWhenObjectIsNotNull() {
        final Integer obj = 1;

        Objects.requireNotNull(obj);
    }

    @Test
    public void failedParameterCheckOnNotNullWhenObjectIsNull() {
        final Integer obj = null;

        try {
            Objects.requireNotNull(obj);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String message = "Should be not null.";

        Objects.requireNotNull(obj, message);
    }

    @Test
    public void failedParameterCheckOnNotNullWithMessageWhenObjectIsNull() {
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
    public void successfulParameterCheckOnNotNullWithMessageSupplierWhenObjectIsNotNull() {
        final Integer obj = 1;
        final Supplier<String> messageSupplier = () -> "Should not be null.";

        Objects.requireNotNull(obj, messageSupplier);
    }

    @Test
    public void failedParameterCheckOnNotNullWithMessageSupplierWhenObjectIsNull() {
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
    public void successfulParameterCheckOnNullWhenObjectIsNull() {
        final Integer obj = null;

        Objects.requireNull(obj);
    }

    @Test
    public void failedParameterCheckOnNullWhenObjectIsNotNull() {
        final Integer obj = 2;

        try {
            Objects.requireNull(obj);
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageWhenObjectIsNull() {
        final Integer obj = null;
        final String message = "Should be null.";

        Objects.requireNull(obj, message);
    }

    @Test
    public void failedParameterCheckOnNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 2;
        final String message = "Should be null.";

        try {
            Objects.requireNull(obj, message);
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            assertThat(e.getMessage(), is(message));
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageSupplierWhenObjectIsNull() {
        final Integer obj = null;
        final Supplier<String> messageSupplier = () -> "Should be null.";

        Objects.requireNull(obj, messageSupplier);
    }

    @Test
    public void failedParameterCheckOnNullWithMessageSupplierWhenObjectIsNotNull() {
        final Integer obj = 2;
        final Supplier<String> messageSupplier = () -> "Should be null.";

        try {
            Objects.requireNull(obj, messageSupplier);
            fail("Should throw exception when parameter is not null.");
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
