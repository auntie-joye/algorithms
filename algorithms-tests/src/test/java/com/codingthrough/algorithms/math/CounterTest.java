package com.codingthrough.algorithms.math;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link Counter}.
 */
public class CounterTest {
    @Test
    public void canCreateCounterWithDefaultName() {
        final Counter actual = new Counter();
        assertThat(actual.getName(), is(Counter.DEFAULT_COUNTER_NAME));
    }

    @Test
    public void canCreateCounterWithDefaultZeroStartPosition() {
        final Counter actual = new Counter();
        assertThat(actual.tally(), is(0));
    }

    @Test
    public void canCreateCounterWithCustomizedName() {
        final String name = "My Counter";
        final Counter actual = new Counter(name);
        assertThat(actual.getName(), is(name));
    }

    @Test
    public void throwsWhenCreateCounterWithNullName() {
        final String name = null;
        try {
            new Counter(name);
            fail("Should throw when counter name is null during construction.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canCreateCounterWithCustomizedStartPosition() {
        final int start = 10;
        final Counter actual = new Counter(start);
        assertThat(actual.tally(), is(10));
    }

    @Test
    public void canCreateCounterWithCustomizedNameAndStartPosition() {
        final String name = "My Counter";
        final int start = 10;
        final Counter actual = new Counter(name, start);

        assertThat(actual.getName(), is(name));
        assertThat(actual.tally(), is(10));
    }

    @Test
    public void throwsWhenCreateCounterWithNullNameAndStartPosition() {
        final String name = null;
        final int start = 10;

        try {
            new Counter(name, start);
            fail("Should throw when counter name is null during construction.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canCreateCounterBasedOnAnotherCounter() {
        final String name = "My Counter";
        final int start = 10;
        final Counter that = new Counter(name, start);

        final Counter actual = new Counter(that);

        assertThat(actual.getName(), is(name));
        assertThat(actual.tally(), is(10));
    }

    @Test
    public void throwsWhenCreateCounterBasedOnNullCounter() {
        final Counter that = null;

        try {
            new Counter(that);
            fail("Should throw when copied counter is null during construction.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canIncrementFromZeroStartPosition() {
        final Counter actual = new Counter();
        actual.increment();
        actual.increment();
        actual.increment();

        assertThat(actual.tally(), is(3));
    }

    @Test
    public void canIncrementFromCustomizedStartPosition() {
        final Counter actual = new Counter(10);
        actual.increment();
        actual.increment();
        actual.increment();

        assertThat(actual.tally(), is(13));
    }

    @Test
    public void canResetFromZeroPosition() {
        final Counter actual = new Counter();
        actual.reset();

        assertThat(actual.tally(), is(0));
    }

    @Test
    public void canResetAfterSeveralIncrements() {
        final Counter actual = new Counter();
        actual.increment();
        actual.increment();
        actual.reset();

        assertThat(actual.tally(), is(0));
    }

    @Test
    public void throwsWhenCompareToNull() {
        final Counter actual = new Counter();
        final Counter that = null;

        try {
            actual.compareTo(that);
            fail("Should throw when compare to null object.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canCompareTheSameCounterReference() {
        final Counter actual = new Counter(2);

        assertThat(actual.compareTo(actual), is(0));
    }

    @Test
    public void canCompareEqualsCounters() {
        final Counter actual = new Counter(2);
        final Counter that = new Counter(2);

        assertThat(actual.compareTo(that), is(0));
    }

    @Test
    public void canCompareLessCounterWithGreater() {
        final Counter actual = new Counter(2);
        final Counter that = new Counter(4);

        assertThat(actual.compareTo(that), is(-1));
    }

    @Test
    public void canCompareGreaterCounterWithLess() {
        final Counter actual = new Counter(6);
        final Counter that = new Counter(4);

        assertThat(actual.compareTo(that), is(1));
    }

    @Test
    public void shouldBeEqualsToTheSameReference() {
        final Counter actual = new Counter(2);
        assertThat(actual.equals(actual), is(true));
    }

    @Test
    public void shouldNotBeEqualsToNull() {
        final Counter actual = new Counter(2);
        final Counter that = null;
        assertThat(actual.equals(that), is(false));
    }

    @Test
    public void shouldNotBeEqualsToAnotherType() {
        final Counter actual = new Counter(2);
        assertThat(actual.equals("counter"), is(false));
    }

    @Test
    public void shouldNotBeEqualsToAnotherCounterWithAnotherCountAndSameName() {
        final Counter actual = new Counter(2);
        final Counter that = new Counter(3);
        assertThat(actual.equals(that), is(false));
    }

    @Test
    public void shouldNotBeEqualsToAnotherCounterWithSameCountAndAnotherName() {
        final Counter actual = new Counter("A", 2);
        final Counter that = new Counter("B", 2);
        assertThat(actual.equals(that), is(false));
    }

    @Test
    public void shouldBeEqualsToAnotherCounterWithTheSameCountAndName() {
        final String name = "My Counter";
        final Counter actual = new Counter(name, 2);
        final Counter that = new Counter(name, 2);
        assertThat(actual.equals(that), is(true));
    }

    @Test
    public void shouldHaveSameHashCodeForCountersWithSameCountsAndNames() {
        final Counter actual = new Counter("A", 2);
        final Counter that = new Counter("A", 2);

        assertThat(actual.hashCode(), is(that.hashCode()));
    }

    @Test
    public void shouldHaveDifferentHashCodeForCountersWithSameCountsAndDifferentNames() {
        final Counter actual = new Counter("A", 2);
        final Counter that = new Counter("B", 2);

        assertThat(actual.hashCode(), is(not(that.hashCode())));
    }

    @Test
    public void shouldHaveDifferenteHashCodeForCountersWithDifferentCountsAndSameNames() {
        final Counter actual = new Counter("A", 2);
        final Counter that = new Counter("A", 3);

        assertThat(actual.hashCode(), is(not(that.hashCode())));
    }
}
