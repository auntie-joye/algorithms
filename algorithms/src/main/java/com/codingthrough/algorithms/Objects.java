package com.codingthrough.algorithms;

import java.util.function.Supplier;

/**
 * This class consists of {@code static} utility methods for operating
 * on objects.
 */
public class Objects {
    /**
     * This class should not be instantiated.
     */
    private Objects() {
    }

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors.
     *
     * @param obj the object reference to check for nullity
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static void requireNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors.
     *
     * @param obj     the object reference to check for nullity
     * @param message the message to be used in exception construction
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static void requireNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors.
     *
     * @param obj             the object reference to check for nullity
     * @param messageSupplier supplier of the detail message to be
     *                        used in the event that a {@code IllegalArgumentException} is thrown
     * @throws IllegalArgumentException if {@code obj} is {@code null}
     */
    public static void requireNotNull(Object obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }

    /**
     * Checks that the specified object reference is {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is not.
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
     * Checks that the specified object reference is {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is not.
     *
     * @param obj     the object reference to check for not nullity
     * @param message the message to be used in exception construction
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj, String message) {
        if (obj != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Checks that the specified object reference is {@code null} and
     * throws a customized {@link IllegalArgumentException} if it is not.
     *
     * @param obj             the object reference to check for not nullity
     * @param messageSupplier supplier of the detail message to be
     *                        used in the event that a {@code IllegalArgumentException} is thrown
     * @throws IllegalArgumentException if {@code obj} is not {@code null}
     */
    public static void requireNull(Object obj, Supplier<String> messageSupplier) {
        if (obj != null) {
            throw new IllegalArgumentException(messageSupplier.get());
        }
    }

    /**
     * Returns {@code true} if the provided reference is {@code null}, otherwise
     * returns {@code false}.
     *
     * @param obj the object reference to check for nullity
     * @return {@code true} if the provided reference is {@code null}, otherwise
     * {@code false}
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * Returns {@code true} if the provided reference is not {@code null},
     * otherwise returns {@code false}.
     *
     * @param obj the object reference to check for nullity
     * @return {@code true} if the provided reference is not {@code null},
     * otherwise {@code false}
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * Consequently, if both arguments are {@code null}, {@code true}
     * is returned and if exactly one argument is {@code null}, {@code
     * false} is returned.  Otherwise, equality is determined by using
     * the {@link Object#equals equals} method of the first
     * argument.
     *
     * @param a the object reference to check for equality
     * @param b the object reference to check for equality
     * @return {@code true} if the provided references are equal to each other,
     * otherwise {@code false}
     */
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
