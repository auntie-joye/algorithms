package com.codingthrough.algorithms;

import org.junit.Test;

import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Preconditions}.
 */
public class PreconditionsTest {
    @Test
    public void successfulParameterCheckOnTrueWhenObjectIsTrue() {
        final boolean expression = true;

        Preconditions.requireTrue(expression);
    }

    @Test
    public void failsParameterCheckOnTrueWhenObjectIsFalse() {
        final boolean expression = false;

        try {
            Preconditions.requireTrue(expression);
            fail("Should throw exception when expression is false.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnTrueWithMessageWhenObjectIsTrue() {
        final boolean expression = true;
        final String message = "Should be true.";

        Preconditions.requireTrue(expression, message);
    }

    @Test
    public void failsParameterCheckOnTrueWithMessageWhenObjectIsFalse() {
        final boolean expression = false;
        final String message = "Should be true.";

        try {
            Preconditions.requireTrue(expression, message);
            fail("Should throw exception when expression is false.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            assertThat(e.getMessage(), is(message));
        }
    }

    @Test
    public void successfulParameterCheckOnTrueWithMessageTemplateWhenObjectIsTrue() {
        final boolean expression = true;
        final String template = "Should be %s.";

        Preconditions.requireTrue(expression, template, true);
    }

    @Test
    public void failsParameterCheckOnTrueWithMessageTemplateWhenObjectIsFalse() {
        final boolean expression = false;
        final String template = "Should be %s.";

        try {
            Preconditions.requireTrue(expression, template, true);
            fail("Should throw exception when expression is false.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            final String expected = String.format(template, true);
            assertThat(e.getMessage(), is(expected));
        }
    }

    @Test
    public void successfulParameterCheckOnTrueWithMessageSupplierWhenObjectIsTrue() {
        final boolean expression = true;
        final Supplier<String> messageSupplier = () -> "Should be true.";

        Preconditions.requireTrue(expression, messageSupplier);
    }

    @Test
    public void failsParameterCheckOnTrueWithMessageSupplierWhenObjectIsFalse() {
        final boolean expression = false;
        final Supplier<String> messageSupplier = () -> "Should be true.";

        try {
            Preconditions.requireTrue(expression, messageSupplier);
            fail("Should throw exception when expression is false.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnFalseWhenObjectIsFalse() {
        final boolean expression = false;

        Preconditions.requireFalse(expression);
    }

    @Test
    public void failsParameterCheckOnFalseWhenObjectIsTrue() {
        final boolean expression = true;

        try {
            Preconditions.requireFalse(expression);
            fail("Should throw exception when expression is true.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnFalseWithMessageWhenObjectIsFalse() {
        final boolean expression = false;
        final String message = "Should be false.";

        Preconditions.requireFalse(expression, message);
    }

    @Test
    public void failsParameterCheckOnFalseWithMessageWhenObjectIsTrue() {
        final boolean expression = true;
        final String message = "Should be false.";

        try {
            Preconditions.requireFalse(expression, message);
            fail("Should throw exception when expression is true.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            assertThat(e.getMessage(), is(message));
        }
    }

    @Test
    public void successfulParameterCheckOnFalseWithMessageTemplateWhenObjectIsFalse() {
        final boolean expression = false;
        final String template = "Should be %s.";

        Preconditions.requireFalse(expression, template, false);
    }

    @Test
    public void failsParameterCheckOnFalseWithMessageTemplateWhenObjectIsTrue() {
        final boolean expression = true;
        final String template = "Should be %s.";

        try {
            Preconditions.requireFalse(expression, template, false);
            fail("Should throw exception when expression is true.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            final String expected = String.format(template, false);
            assertThat(e.getMessage(), is(expected));
        }
    }

    @Test
    public void successfulParameterCheckOnFalseWithMessageSupplierWhenObjectIsFalse() {
        final boolean expression = false;
        final Supplier<String> messageSupplier = () -> "Should be false.";

        Preconditions.requireFalse(expression, messageSupplier);
    }

    @Test
    public void failsParameterCheckOnFalseWithMessageSupplierWhenObjectIsTrue() {
        final boolean expression = true;
        final Supplier<String> messageSupplier = () -> "Should be false.";

        try {
            Preconditions.requireFalse(expression, messageSupplier);
            fail("Should throw exception when expression is true.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWhenObjectIsNotNull() {
        final Integer obj = 1;

        Preconditions.ensureNotNull(obj);
    }

    @Test
    public void failsParameterCheckOnNotNullWhenObjectIsNull() {
        final Integer obj = null;

        try {
            Preconditions.ensureNotNull(obj);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String message = "Should not be null.";

        final Integer actual = Preconditions.ensureNotNull(obj, message);
        assertThat(actual, is(obj));
    }

    @Test
    public void failsParameterCheckOnNotNullWithMessageWhenObjectIsNull() {
        final Integer obj = null;
        final String message = "Should not be null.";

        try {
            Preconditions.ensureNotNull(obj, message);
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

        final Integer actual = Preconditions.ensureNotNull(obj, messageSupplier);
        assertThat(actual, is(obj));
    }

    @Test
    public void failsParameterCheckOnNotNullWithMessageSupplierWhenObjectIsNull() {
        final Integer obj = null;
        final Supplier<String> messageSupplier = () -> "Should not be null.";

        try {
            Preconditions.ensureNotNull(obj, messageSupplier);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWithMessageTemplateWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String template = "Should not be %s.";

        final Integer actual = Preconditions.ensureNotNull(obj, template, "null");
        assertThat(actual, is(obj));
    }

    @Test
    public void failsParameterCheckOnNotNullWithMessageTemplateWhenObjectIsNull() {
        final Integer obj = null;
        final String template = "Should not be %s.";

        try {
            Preconditions.ensureNotNull(obj, template, "null");
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            final String expected = String.format(template, "null");
            assertThat(e.getMessage(), is(expected));
        }
    }

    @Test
    public void successfulParameterCheckOnNullWhenObjectIsNull() {
        final Integer obj = null;

        Preconditions.requireNull(obj);
    }

    @Test
    public void failsParameterCheckOnNullWhenObjectIsNotNull() {
        final Integer obj = 2;

        try {
            Preconditions.requireNull(obj);
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageWhenObjectIsNull() {
        final Integer obj = null;
        final String message = "Should be null.";

        Preconditions.requireNull(obj, message);
    }

    @Test
    public void failsParameterCheckOnNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 2;
        final String message = "Should be null.";

        try {
            Preconditions.requireNull(obj, message);
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            assertThat(e.getMessage(), is(message));
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageTemplateWhenObjectIsNull() {
        final Integer obj = null;
        final String template = "Should be %s.";

        Preconditions.requireNull(obj, template, "null");
    }

    @Test
    public void failsParameterCheckOnNullWithMessageTemplateWhenObjectIsNotNull() {
        final Integer obj = 2;
        final String template = "Should be %s.";

        try {
            Preconditions.requireNull(obj, template, "null");
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
            final String expected = String.format(template, "null");
            assertThat(e.getMessage(), is(expected));
        }
    }

    @Test
    public void successfulParameterCheckOnNullWithMessageSupplierWhenObjectIsNull() {
        final Integer obj = null;
        final Supplier<String> messageSupplier = () -> "Should be null.";

        Preconditions.requireNull(obj, messageSupplier);
    }

    @Test
    public void failsParameterCheckOnNullWithMessageSupplierWhenObjectIsNotNull() {
        final Integer obj = 2;
        final Supplier<String> messageSupplier = () -> "Should be null.";

        try {
            Preconditions.requireNull(obj, messageSupplier);
            fail("Should throw exception when parameter is not null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

}
