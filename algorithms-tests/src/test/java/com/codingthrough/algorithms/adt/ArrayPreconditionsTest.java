package com.codingthrough.algorithms.adt;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Unit tests for {@link ArrayPreconditions}.
 */
public class ArrayPreconditionsTest {
    @Test
    public void successfulCheckWhenAllParametersAreInBounds() {
        ArrayPreconditions.ensureBounds(4, 1, 2);
    }

    @Test
    public void successfulCheckWhenLowBoundIsTheFirstArrayIndex() {
        ArrayPreconditions.ensureBounds(4, 0, 2);
    }

    @Test
    public void successfulCheckWhenUpperBoundIsTheLastArrayIndex() {
        ArrayPreconditions.ensureBounds(4, 1, 3);
    }

    @Test
    public void throwsCheckWhenAllParametersAreZeros() {
        try {
            ArrayPreconditions.ensureBounds(0, 0, 0);
            fail("Should throw when array is empty and all other indexes are zero.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void successfulCheckWhenArrayHasOneElement() {
        ArrayPreconditions.ensureBounds(1, 0, 0);
    }

    @Test
    public void successfulCheckWhenLowBoundEqualsUpperBound() {
        ArrayPreconditions.ensureBounds(3, 1, 1);
    }

    @Test
    public void failsWhenLowBoundIsGreaterThanUpperBound() {
        try {
            ArrayPreconditions.ensureBounds(3, 2, 1);
            fail("Should throw when low bound is greater than upper bound.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failsWhenLowBoundIsLessThenTheFirstArrayIndex() {
        try {
            ArrayPreconditions.ensureBounds(3, -1, 1);
            fail("Should throw when low bound is less then the first array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failsWhenUpperBoundIsGreaterThenTheLastArrayIndex() {
        try {
            ArrayPreconditions.ensureBounds(3, 1, 3);
            fail("Should throw when upper bound is greater then the last array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }
}
