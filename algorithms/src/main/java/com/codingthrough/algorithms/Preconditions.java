package com.codingthrough.algorithms;

import java.util.function.Supplier;

/**
 * This class consists of {@code static} utility methods that
 * help a method or constructor check whether it is invoked
 * correctly, in other words, whether all its preconditions are met.
 */
public class Preconditions {
    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code true} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression the boolean expression
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void requireTrue(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code true} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression   the boolean expression
     * @param errorMessage the message to be used in exception construction
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void requireTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code true} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression      the boolean expression
     * @param messageSupplier supplier of the detail message to be
     *                        used in the event that a {@code IllegalArgumentException} is thrown
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void requireTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code true} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression           the boolean expression
     * @param errorMessageTemplate the template for the exception error message. The
     *                             message is formed by using {@link String#format(String, Object...)} ()}
     *                             method.
     * @param errorMessageArgs     the arguments to be substituted into the error message template
     * @throws IllegalArgumentException if {@code expression} is {@code false}
     */
    public static void requireTrue(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (!expression) {
            final String errorMessage = String.format(errorMessageTemplate, errorMessageArgs);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code false} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression the boolean expression
     * @throws IllegalArgumentException if {@code expression} is {@code true}
     */
    public static void requireFalse(boolean expression) {
        if (expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code false} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression   the boolean expression
     * @param errorMessage the message to be used in exception construction
     * @throws IllegalArgumentException if {@code expression} is {@code true}
     */
    public static void requireFalse(boolean expression, String errorMessage) {
        if (expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code false} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression      the boolean expression
     * @param messageSupplier supplier of the detail message to be
     *                        used in the event that a {@code IllegalArgumentException} is thrown
     * @throws IllegalArgumentException if {@code expression} is {@code true}
     */
    public static void requireFalse(boolean expression, Supplier<String> messageSupplier) {
        if (expression) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }

    /**
     * Ensures that the specified boolean expression passed as
     * a parameter is {@code false} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param expression           the boolean expression
     * @param errorMessageTemplate the template for the exception error message. The
     *                             message is formed by using {@link String#format(String, Object...)} ()}
     *                             method.
     * @param errorMessageArgs     the arguments to be substituted into the error message template
     * @throws IllegalArgumentException if {@code expression} is {@code true}
     */
    public static void requireFalse(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (expression) {
            final String errorMessage = String.format(errorMessageTemplate, errorMessageArgs);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is not {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is.
     *
     * @param obj the object reference to check for nullity
     * @return the object reference
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static <T> T ensureNotNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        return obj;
    }


    /**
     * Ensures that the specified object reference passed as
     * a parameter is not {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is.
     *
     * @param obj          the object reference to check for nullity
     * @param errorMessage the message to be used in exception construction
     * @return the object reference
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static <T> T ensureNotNull(T obj, String errorMessage) {
        if (obj == null) {
            throw new IllegalArgumentException(errorMessage);
        }
        return obj;
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is not {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is.
     *
     * @param obj             the object reference to check for nullity
     * @param messageSupplier supplier of the detail message to be
     *                        used in the event that a {@code IllegalArgumentException} is thrown
     * @return the object reference
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static <T> T ensureNotNull(T obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
        return obj;
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is not {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is.
     *
     * @param obj                  the object reference to check for nullity
     * @param errorMessageTemplate the template for the exception error message. The
     *                             message is formed by using {@link String#format(String, Object...)} ()}
     *                             method.
     * @param errorMessageArgs     the arguments to be substituted into the error message template.
     * @return the object reference
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static <T> T ensureNotNull(T obj, String errorMessageTemplate, Object... errorMessageArgs) {
        if (obj == null) {
            final String errorMessage = String.format(errorMessageTemplate, errorMessageArgs);
            throw new IllegalArgumentException(errorMessage);
        }
        return obj;
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param obj the object reference to check for not nullity
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param obj          the object reference to check for not nullity
     * @param errorMessage the message to be used in exception construction
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj, String errorMessage) {
        if (obj != null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is not.
     *
     * @param obj             the object reference to check for not nullity
     * @param messageSupplier supplier of the detail message to be used in
     *                        the event that a {@code IllegalArgumentException} is thrown
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj, Supplier<String> messageSupplier) {
        if (obj != null) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }

    /**
     * Ensures that the specified object reference passed as
     * a parameter is {@code null} and throws a customized
     * {@link IllegalArgumentException} if it is.
     *
     * @param obj                  the object reference to check for nullity
     * @param errorMessageTemplate the template for the exception error message. The
     *                             message is formed by using {@link String#format(String, Object...)} ()}
     *                             method.
     * @param errorMessageArgs     the arguments to be substituted into the error message template.
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj, String errorMessageTemplate, Object... errorMessageArgs) {
        if (obj != null) {
            final String errorMessage = String.format(errorMessageTemplate, errorMessageArgs);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
