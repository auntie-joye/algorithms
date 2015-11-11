package com.codingthrough.algorithms.adt.bag;

import javax.annotation.Nullable;
import java.util.Iterator;

/**
 * Contains common methods for the bag implementations that are
 * the same and independent of chosen implementation strategy.
 */
public abstract class AbstractBag<E> implements Bag<E> {
    /**
     * Current size of the bag.
     */
    protected int size = 0;

    /**
     * The number of times this bag has been <i>structurally modified</i>.
     * Structural modifications are those that change the size of the
     * bag, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.
     * <p>
     * <p>This field is used by the bag iterator implementation
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

    /**
     * {@inheritDoc}
     * <p>
     * <p>This implementation iterates over the elements in the bag,
     * checking each element in turn for equality with the specified element.
     */
    public boolean contains(@Nullable E item) {
        final Iterator<E> it = iterator();
        if (item == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (item.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
