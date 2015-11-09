package com.codingthrough.algorithms.collection;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Arrays}.
 */
public class ArrayPreconditionsTest {
    @Test
    public void successfulCheckWhenAllParametersAreInBounds() {
        Arrays.checkBounds(4, 1, 2);
    }

    @Test
    public void successfulCheckWhenLowBoundIsTheFirstArrayIndex() {
        Arrays.checkBounds(4, 0, 2);
    }

    @Test
    public void successfulCheckWhenUpperBoundIsTheLastArrayIndex() {
        Arrays.checkBounds(4, 1, 3);
    }

    @Test
    public void successfulCheckWhenAllParametersAreZeros() {
        Arrays.checkBounds(0, 0, 0);
    }

    @Test
    public void successfulCheckWhenArrayHasOneElement() {
        Arrays.checkBounds(1, 0, 1);
    }

    @Test
    public void successfulCheckWhenLowBoundEqualsUpperBound() {
        Arrays.checkBounds(3, 1, 1);
    }

    @Test
    public void failedWhenLowBoundIsGreaterThanUpperBound() {
        try {
            Arrays.checkBounds(3, 2, 1);
            fail("Should throw when low bound is greater than upper bound.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failedWhenLowBoundIsLessThenTheFirstArrayIndex() {
        try {
            Arrays.checkBounds(3, -1, 1);
            fail("Should throw when low bound is less then the first array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }

    @Test
    public void failedWhenUpperBoundIsGreaterThenTheLastArrayIndex() {
        try {
            Arrays.checkBounds(3, 1, 3);
            fail("Should throw when upper bound is greater then the last array index.");
        } catch (IllegalArgumentException e) {
            // it's expected exception
        }
    }
}
