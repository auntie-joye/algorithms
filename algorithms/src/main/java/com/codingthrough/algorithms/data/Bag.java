package com.codingthrough.algorithms.data;

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
    boolean add(final E item);

    /**
     * Appends all of the elements in the specified array to the bag,
     * in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified array is modified while
     * the operation is in progress.
     * (Note that this will occur if the specified array is this list,
     * and it's nonempty.)
     *
     * @param a array containing elements to be added to this bag
     * @return <tt>true</tt> if this bag changed as a result of the call
     */
    boolean addAll(final E[] a);

    /**
     * Appends all of the elements in the specified bag to the bag,
     * in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified bag is modified while
     * the operation is in progress.
     * (Note that this will occur if the specified bag is this list,
     * and it's nonempty.)
     *
     * @param bag bag containing elements to be added to this bag
     * @return <tt>true</tt> if this bag changed as a result of the call
     */
    boolean addAll(final Bag<E> bag);

    /**
     * Returns <tt>true</tt> if this bag contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this bag contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param item element whose presence in this bag is to be tested
     * @return <tt>true</tt> if this bag contains the specified element
     */
    boolean contains(final E item);

    /**
     * Returns <tt>true</tt> if this bag contains to elements,
     * otherwise - return <tt>false</tt>.
     *
     * @return <tt>true</tt> if this bag contains to elements,
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
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
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
     * <p>If the bag fits in the specified array with room to spare (i.e.,
     * the array has more elements than the bag), the element in the array
     * immediately following the end of the bag is set to <tt>null</tt>.
     * (This is useful in determining the length of the bag <i>only</i> if
     * the caller knows that the bag does not contain any null elements.)
     * <p>
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     * <p>
     * <p>Suppose <tt>x</tt> is a bag known to contain only strings.
     * The following code can be used to dump the bag into a newly
     * allocated array of <tt>String</tt>:
     * <p>
     * <pre>{@code
     *     String[] y = x.toArray(new String[0]);
     * }</pre>
     * <p>
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param a the array into which the elements of this bag are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this bag
     * @throws ArrayStoreException  if the runtime type of the specified array
     *                              is not a supertype of the runtime type of every element in
     *                              this bag
     * @throws NullPointerException if the specified array is null
     */
    <T> T[] toArray(T[] a);
}
