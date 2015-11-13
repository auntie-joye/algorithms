package com.codingthrough.algorithms.adt.bag;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.codingthrough.algorithms.matchers.IsIteratorContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link ArrayBag}.
 */
public class ArrayBagTest {
    @Test
    public void canCreateEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();

        assertThat(bag.size(), is(0));
        assertThat(bag.empty(), is(true));
    }

    @Test
    public void throwsWhenCreateBagFromNullBag() {
        final Bag<Integer> other = null;
        try {
            new ArrayBag<>(other);
            fail("Should throw when create new bag from null bag.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canCreateBagFromAnotherEmptyBag() {
        final Bag<Integer> other = new ArrayBag<>();
        final Bag<Integer> bag = new ArrayBag<>(other);

        assertThat(bag.size(), is(0));
        assertThat(bag.empty(), is(true));
    }

    @Test
    public void canCreateBagFromAnotherNotEmptyBag() {
        final Bag<Integer> other = new ArrayBag<>();
        other.add(1);
        other.add(2);

        final Bag<Integer> bag = new ArrayBag<>(other);

        assertThat(bag.size(), is(2));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void throwsWhenCreateBagFromNullArray() {
        final Integer[] other = null;
        try {
            new ArrayBag<>(other);
            fail("Should throw when create new bag from null array.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canCreateBagFromAnotherEmptyArray() {
        final Integer[] other = new Integer[0];
        final Bag<Integer> bag = new ArrayBag<>(other);

        assertThat(bag.size(), is(0));
        assertThat(bag.empty(), is(true));
    }

    @Test
    public void canCreateBagFromAnotherNotEmptyArray() {
        final Integer[] other = new Integer[]{1, 2};

        final Bag<Integer> bag = new ArrayBag<>(other);

        assertThat(bag.size(), is(2));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canAddNewElementToEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        assertThat(bag.size(), is(1));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canAddNewElementToNotEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        assertThat(bag.size(), is(2));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canAddNullElementToSomeBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(2);

        assertThat(bag.size(), is(3));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canAddRepeatedElementToSomeBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(2);

        assertThat(bag.size(), is(3));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canIterateOverBagAfterAddingSeveralElements() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        final Iterator<Integer> iterator = bag.iterator();
        assertThat(iterator, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void returnsTrueWhenNewElementIsAdded() {
        final Bag<Integer> bag = new ArrayBag<>();

        assertThat(bag.add(1), is(true));
    }

    @Test
    public void throwsWhenAddAllFromNullArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        final Integer[] a = null;

        try {
            bag.addAll(a);
            fail("Should throw when add all from null array.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canAddAllFromEmptyArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Integer[] a = new Integer[0];
        bag.addAll(a);

        assertThat(bag.size(), is(1));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void returnsFalseWhenAddAllFromEmptyArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Integer[] a = new Integer[0];

        assertThat(bag.addAll(a), is(false));
    }

    @Test
    public void canAddAllFromNotEmptyArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Integer[] a = new Integer[]{2, 3};
        bag.addAll(a);

        assertThat(bag.size(), is(3));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void returnsTrueWhenAddAllFromNotEmptyArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Integer[] a = new Integer[]{2, 3};

        assertThat(bag.addAll(a), is(true));
    }

    @Test
    public void canIterateOverBagAfterAddingAllFromSomeArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Integer[] a = new Integer[]{2, 3};
        bag.addAll(a);

        final Iterator<Integer> iterator = bag.iterator();
        assertThat(iterator, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void throwsWhenAddAllFromNullIterable() {
        final Bag<Integer> bag = new ArrayBag<>();
        final Bag<Integer> other = null;

        try {
            bag.addAll(other);
            fail("Should throw when add all from null iterable collection.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canAddAllFromEmptyIterableCollection() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Bag<Integer> other = new ArrayBag<>();
        bag.addAll(other);

        assertThat(bag.size(), is(1));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void returnsFalseWhenAddAllFromEmptyIterableCollection() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Bag<Integer> other = new ArrayBag<>();

        assertThat(bag.addAll(other), is(false));
    }

    @Test
    public void canAddAllFromNotEmptyIterableCollection() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Bag<Integer> other = new ArrayBag<>();
        other.add(2);
        other.add(3);

        bag.addAll(other);

        assertThat(bag.size(), is(3));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void canAddAllFromTheSameBagReference() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        bag.addAll(bag);

        assertThat(bag.size(), is(2));
        assertThat(bag.empty(), is(false));
    }

    @Test
    public void returnsTrueWhenAddAllFromNotEmptyIterableCollection() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);

        final Bag<Integer> other = new ArrayBag<>();
        other.add(2);
        other.add(3);

        assertThat(bag.addAll(other), is(true));
    }

    @Test
    public void canIterateOverBagAfterAddingAllFromSomeIterableCollection() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);


        final Bag<Integer> other = new ArrayBag<>();
        other.add(2);
        other.add(3);

        bag.addAll(other);

        final Iterator<Integer> iterator = bag.iterator();
        assertThat(iterator, containsInAnyOrder(1, 2, 3));
    }

    @Test
    public void canConvertEmptyBagToArray() {
        final Bag<Integer> bag = new ArrayBag<>();

        final Object[] actual = bag.toArray();

        assertThat(actual.length, is(0));
    }

    @Test
    public void canConvertNotEmptyBagToArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Object[] actual = bag.toArray();

        assertThat(actual.length, is(2));
        assertThat(actual[0], is(1));
        assertThat(actual[1], is(2));
    }

    @Test
    public void canConvertBagWithNullElementToArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(2);

        final Object[] actual = bag.toArray();

        assertThat(actual.length, is(3));
        assertThat(actual, arrayContainingInAnyOrder(1, 2, null));
    }

    @Test
    public void throwsWhenConvertBagUsingNullArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        final Integer[] a = null;

        try {
            bag.toArray(a);
            fail("Should throw when convert bag to array using null object.");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void canConvertEmptyBagToArrayUsingArgumentArrayWithZeroLength() {
        final Bag<Integer> bag = new ArrayBag<>();
        final Integer[] a = new Integer[0];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(0));
    }

    @Test
    public void canConvertEmptyBagToArrayUsingArgumentArrayWithLargerLength() {
        final Bag<Integer> bag = new ArrayBag<>();
        final Integer[] a = new Integer[2];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(2));
    }

    @Test
    public void canConvertNotEmptyBagToArrayUsingArgumentArrayWithLessLength() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Integer[] a = new Integer[1];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(2));
        assertThat(actual, arrayContainingInAnyOrder(1, 2));
    }

    @Test
    public void canConvertNotEmptyBagToArrayUsingArgumentArrayWithEqualLength() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Integer[] a = new Integer[2];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(2));
        assertThat(actual, arrayContainingInAnyOrder(1, 2));
    }

    @Test
    public void canConvertNotEmptyBagToArrayUsingArgumentArrayWithLargerLength() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Integer[] a = new Integer[3];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(3));
        assertThat(actual, arrayContainingInAnyOrder(1, 2, null));
    }

    @Test
    public void canConvertBagWithNullElementToArrayUsingArgumentArray() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(2);

        final Integer[] a = new Integer[3];

        final Integer[] actual = bag.toArray(a);

        assertThat(actual.length, is(3));
        assertThat(actual, arrayContainingInAnyOrder(1, 2, null));
    }

    @Test
    public void throwsWhenCallNextAfterIteratingOverLastElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Iterator<Integer> iterator = bag.iterator();
        iterator.next();
        iterator.next();

        try {
            iterator.next();
            fail("Should throw when call next after iterating over last element.");
        } catch (NoSuchElementException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenAddElementToBagDuringIteration() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Iterator<Integer> iterator = bag.iterator();
        iterator.next();
        bag.add(1);

        try {
            iterator.next();
            fail("Should throw when add element to bag during iteration.");
        } catch (ConcurrentModificationException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void throwsWhenCallAddAllDuringIteration() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Iterator<Integer> iterator = bag.iterator();
        iterator.next();

        final Integer[] a = new Integer[]{3};
        bag.addAll(a);

        try {
            iterator.next();
            fail("Should throw when call addAll() during iteration.");
        } catch (ConcurrentModificationException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void doesNotThrowWhenCallAddAllForEmptyCollectionDuringIteration() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);

        final Iterator<Integer> iterator = bag.iterator();
        iterator.next();

        final Integer[] a = new Integer[0];
        bag.addAll(a);

        final Integer actual = iterator.next();
        assertThat(actual, is(2));
    }

    @Test
    public void returnsFalseForContainsOverEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();

        assertThat(bag.contains(2), is(false));
    }

    @Test
    public void returnsFalseForContainsOverSomeBagWithNoSuchElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(3);
        bag.add(4);

        assertThat(bag.contains(2), is(false));
    }

    @Test
    public void returnsTrueForContainsOverSomeBagWithSuchElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        assertThat(bag.contains(2), is(true));
    }

    @Test
    public void canCallContainsForNullElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);

        assertThat(bag.contains(null), is(false));
    }

    @Test
    public void canCallContainsForBagWithNullElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(3);

        assertThat(bag.contains(3), is(true));
    }

    @Test
    public void canFindNullElement() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(3);

        assertThat(bag.contains(null), is(true));
    }

    @Test
    public void canClearEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.clear();

        assertThat(bag.size(), is(0));
        assertThat(bag.empty(), is(true));
    }

    @Test
    public void canClearNotEmptyBag() {
        final Bag<Integer> bag = new ArrayBag<>();
        bag.add(1);
        bag.add(null);
        bag.add(3);

        bag.clear();

        assertThat(bag.size(), is(0));
        assertThat(bag.empty(), is(true));
    }
}
