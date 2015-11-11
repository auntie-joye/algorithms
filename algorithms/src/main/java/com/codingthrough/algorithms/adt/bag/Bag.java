package com.codingthrough.algorithms.adt.bag;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Iterator;

/**
 * The <tt>Bag</tt> class represents a bag (or multiset) of
 * generic items. It supports insertion and iterating over the
 * items in arbitrary order.
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * Inserts the specified element into the bag.
     *
     * @param item the element to add
     */
    boolean add(@Nullable final E item);

    /**
     * Appends all of the elements in the specified array to the bag,
     * in the order that they are returned by the specified
     * array's iterator (optional operation). The behavior of this
     * operation is undefined if the specified array is modified while
     * the operation is in progress.
     *
     * @param a array containing elements to be added to this bag
     * @return <tt>true</tt> if this bag changed as a result of the call
     */
    boolean addAll(@Nonnull final E[] a);

    /**
     * Appends all of the elements in the specified collection to the current bag,
     * in the order that they are returned by the specified
     * collection's iterator (optional operation). The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.
     *
     * @param a collection containing elements to be added to this bag
     * @return <tt>true</tt> if this bag changed as a result of the call
     */
    boolean addAll(@Nonnull final Iterable<E> a);

    /**
     * Appends all of the elements returned by the specified
     * collection's iterator to the current bag. The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.
     *
     * @param a iterator returning elements to be added to this bag
     * @return <tt>true</tt> if this bag changed as a result of the call
     */
    boolean addAll(@Nonnull final Iterator<E> a);

    /**
     * Returns <tt>true</tt> if this bag contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this bag contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param item element whose presence in this bag is to be tested
     * @return <tt>true</tt> if this bag contains the specified element,
     * otherwise - return <tt>false</tt>
     */
    boolean contains(@Nullable final E item);

    /**
     * Removes all elements from the bag, returns to the initial state.
     */
    void clear();

    /**
     * Returns <tt>true</tt> if this bag contains no elements,
     * otherwise - return <tt>false</tt>.
     *
     * @return <tt>true</tt> if this bag contains no elements,
     * otherwise - return <tt>false</tt>
     */
    default boolean empty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements in the bag. If this bag contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in the bag
     */
    int size();

    /**
     * Returns an array containing all of the elements in this bag.
     * <p>
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this bag.  (In other words, this method must
     * allocate a new array even if this bag is backed by an array).
     * The caller is thus free to modify the returned array.
     * <p>
     *
     * @return an array containing all of the elements in this bag
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this bag;
     * the runtime type of the returned array is that of the specified array.
     * <p>
     * If the bag fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this bag.
     * <p>
     *
     * @param a the array into which the elements of this bag are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this bag
     * @throws ArrayStoreException if the runtime type of the specified array
     *                             is not a supertype of the runtime type of every element in
     *                             this bag
     */
    <T> T[] toArray(@Nonnull T[] a);
}
