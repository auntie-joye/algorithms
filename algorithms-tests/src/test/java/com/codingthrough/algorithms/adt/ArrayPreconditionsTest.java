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
    public void successfulCheckWhenAllParametersAreZeros() {
        ArrayPreconditions.ensureBounds(0, 0, 0);
    }

    @Test
    public void successfulCheckWhenArrayHasOneElement() {
        ArrayPreconditions.ensureBounds(1, 0, 1);
    }

    @Test
    public void successfulCheckWhenLowBoundEqualsUpperBound() {
        ArrayPreconditions.ensureBounds(3, 1, 1);
    }

    @Test
    public void failedWhenLowBoundIsGreaterThanUpperBound() {
        try {
            ArrayPreconditions.ensureBounds(3, 2, 1);
            fail("Should throw when low bound is greater than upper bound.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failedWhenLowBoundIsLessThenTheFirstArrayIndex() {
        try {
            ArrayPreconditions.ensureBounds(3, -1, 1);
            fail("Should throw when low bound is less then the first array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failedWhenUpperBoundIsGreaterThenTheLastArrayIndex() {
        try {
            ArrayPreconditions.ensureBounds(3, 1, 3);
            fail("Should throw when upper bound is greater then the last array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }
}
