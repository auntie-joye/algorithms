package com.codingthrough.algorithms.math;

import com.codingthrough.algorithms.Objects;

import javax.annotation.Nonnull;
import java.io.Serializable;

import static com.codingthrough.algorithms.Preconditions.requireNotNull;

/**
 * The <tt>Counter</tt> class is a mutable data type of type {code int}
 * to track counts of values.
 */
@SuppressWarnings("NullableProblems")
public class Counter implements Comparable<Counter>, Serializable {
    /**
     * Default name of the counter.
     */
    static final String DEFAULT_COUNTER_NAME = "Counter";

    /**
     * The name of the counter, an optional field. If it is
     * not set, a default name is used.
     */
    private String name = DEFAULT_COUNTER_NAME;

    /**
     * The values tracking counter, by default the start position
     * is zero.
     */
    private int count = 0;

    /**
     * Creates a new counter with default name
     * and zero as a start position.
     */
    public Counter() {
    }

    /**
     * Creates a new counter with the specified name
     * and zero as a start position.
     */
    public Counter(@Nonnull String name) {
        requireNotNull(name, "The name of the counter should not be null.");

        this.name = name;
    }

    /**
     * Creates a new counter with default name
     * and the specified count as a start position.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * Creates a new counter with the specified name
     * and the specified count as a start position.
     */
    public Counter(@Nonnull String name, int count) {
        requireNotNull(name, "The name of the counter should not be null.");

        this.name = name;
        this.count = count;
    }

    /**
     * Creates a new counter based on the specified
     * counter name and current counter state.
     */
    public Counter(@Nonnull Counter that) {
        requireNotNull(that, "Counter [that] should not be null.");

        this.name = that.getName();
        this.count = that.tally();
    }

    /**
     * Increments count by one.
     */
    public Counter increment() {
        count++;
        return this;
    }

    /**
     * Returns the current count state.
     *
     * @return current count state of type {@code int}
     */
    public int tally() {
        return count;
    }

    /**
     * Sets current count to zero.
     */
    public Counter reset() {
        count = 0;
        return this;
    }

    /**
     * Returns the name of the counter.
     *
     * @return name of the counter
     */
    public String getName() {
        return name;
    }

    /**
     * Returns string representation of the counter state.
     * Be default, it concatenates the name and the count of the counter.
     *
     * @return string representation of the counter
     */
    public String toString() {
        return name + ": " + count;
    }

    @Override
    public int compareTo(@Nonnull Counter that) {
        requireNotNull(that, "Counter [that] should not be null.");

        if (this.tally() > that.tally()) {
            return +1;
        } else if (this.tally() < that.tally()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Counter)) {
            return false;
        }

        Counter that = (Counter) obj;
        return this.tally() == that.tally() &&
                this.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, count);
    }
}
