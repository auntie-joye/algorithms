package com.codingthrough.algorithms.adt.stack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * The <tt>Stack</tt> interface represents a last-in-first-out (LIFO) stack of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 * for peeking at the top item, testing if the stack is empty, and iterating through
 * the items in LIFO order.
 */
public interface Stack<E> extends Iterable<E> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack.
     */
    void push(@Nullable final E item);

    /**
     * Pushes an array of items onto the top of this stack, traversing array from zero index.
     *
     * @param a the array of items to be pushed onto this stack.
     */
    void pushAll(@Nonnull final E[] a);

    /**
     * Pushes a iterable collection of items onto the top of this stack. The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.
     *
     * @param a the iterable collection of items to be pushed onto this stack.
     */
    void pushAll(@Nonnull final Iterable<E> a);

    /**
     * Pushes all of the elements returned by the specified
     * collection's iterator nto the top of this stack. The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.
     *
     * @param a iterator returning elements to be pushed onto this stack.
     */
    void pushAll(@Nonnull final Iterator<E> a);

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    E pop();

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    E peek();

    /**
     * Removes all elements from the stack, returns to the initial state.
     */
    void clear();

    /**
     * Returns <tt>true</tt> if this stack contains no elements,
     * otherwise - return <tt>false</tt>.
     *
     * @return <tt>true</tt> if this stack contains no elements,
     * otherwise - return <tt>false</tt>
     */
    default boolean empty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements in the stack. If this stack contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns an array containing all of the elements in this stack.
     * <p>
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this stack.  (In other words, this method must
     * allocate a new array even if this stack is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * @return an array containing all of the elements in this stack
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this stack;
     * the runtime type of the returned array is that of the specified array.
     * <p>
     * If the stack fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this stack.
     *
     * @param a the array into which the elements of this stack are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this stack
     * @throws ArrayStoreException if the runtime type of the specified array
     *                             is not a supertype of the runtime type of every element in
     *                             this stack
     */
    <T> T[] toArray(@Nonnull T[] a);
}
