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
    public void failedParameterCheckOnTrueWhenObjectIsFalse() {
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
    public void failedParameterCheckOnTrueWithMessageWhenObjectIsFalse() {
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
    public void failedParameterCheckOnTrueWithMessageTemplateWhenObjectIsFalse() {
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
    public void failedParameterCheckOnTrueWithMessageSupplierWhenObjectIsFalse() {
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
    public void failedParameterCheckOnFalseWhenObjectIsTrue() {
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
    public void failedParameterCheckOnFalseWithMessageWhenObjectIsTrue() {
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
    public void failedParameterCheckOnFalseWithMessageTemplateWhenObjectIsTrue() {
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
    public void failedParameterCheckOnFalseWithMessageSupplierWhenObjectIsTrue() {
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

        Preconditions.requireNotNull(obj);
    }

    @Test
    public void failedParameterCheckOnNotNullWhenObjectIsNull() {
        final Integer obj = null;

        try {
            Preconditions.requireNotNull(obj);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWithMessageWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String message = "Should be not null.";

        final Integer actual = Preconditions.requireNotNull(obj, message);
        assertThat(actual, is(obj));
    }

    @Test
    public void failedParameterCheckOnNotNullWithMessageWhenObjectIsNull() {
        final Integer obj = null;
        final String message = "Should be not null.";

        try {
            Preconditions.requireNotNull(obj, message);
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

        final Integer actual = Preconditions.requireNotNull(obj, messageSupplier);
        assertThat(actual, is(obj));
    }

    @Test
    public void failedParameterCheckOnNotNullWithMessageSupplierWhenObjectIsNull() {
        final Integer obj = null;
        final Supplier<String> messageSupplier = () -> "Should not be null.";

        try {
            Preconditions.requireNotNull(obj, messageSupplier);
            fail("Should throw exception when parameter is null.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void successfulParameterCheckOnNotNullWithMessageTemplateWhenObjectIsNotNull() {
        final Integer obj = 1;
        final String template = "Should not be %s.";

        final Integer actual = Preconditions.requireNotNull(obj, template, "null");
        assertThat(actual, is(obj));
    }

    @Test
    public void failedParameterCheckOnNotNullWithMessageTemplateWhenObjectIsNull() {
        final Integer obj = null;
        final String template = "Should not be %s.";

        try {
            Preconditions.requireNotNull(obj, template, "null");
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
    public void failedParameterCheckOnNullWhenObjectIsNotNull() {
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
    public void failedParameterCheckOnNullWithMessageWhenObjectIsNotNull() {
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
    public void failedParameterCheckOnNullWithMessageTemplateWhenObjectIsNotNull() {
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
    public void failedParameterCheckOnNullWithMessageSupplierWhenObjectIsNotNull() {
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
