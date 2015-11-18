package com.codingthrough.algorithms.adt.stack;

import java.util.EmptyStackException;

/**
 * Contains common methods that are the same and independent of chosen implementation strategy.
 */
public abstract class AbstractStack<E> implements Stack<E> {
    /**
     * Current size of the stack.
     */
    protected int size = 0;

    /**
     * The number of times this stack has been <i>structurally modified</i>.
     * Structural modifications are those that change the size of the
     * stack, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.
     * <p>
     * <p>This field is used by the stack iterator implementation
     * returned by the {@code iterator} method.
     * If the value of this field changes unexpectedly, the iterator will throw
     * a {@code ConcurrentModificationException} in response to the {@code next}
     * operation.
     * <p>
     * This provides
     * <i>fail-fast</i> behavior, rather than non-deterministic behavior in
     * the face of concurrent modification during iteration.
     * <p>
     */
    protected int modCount = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    protected void ensureNotEmpty() {
        if (empty()) {
            throw new EmptyStackException();
        }
    }
}
