package com.codingthrough.algorithms.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matches the specified iterator has all specified items in any order, that there is no absent or extra item.
 */
public class IsIteratorContainingInAnyOrder<E> extends TypeSafeDiagnosingMatcher<Iterator<? extends E>> {
    private final Collection<Matcher<? super E>> matchers;

    public IsIteratorContainingInAnyOrder(Collection<Matcher<? super E>> matchers) {
        this.matchers = matchers;
    }

    @Override
    protected boolean matchesSafely(Iterator<? extends E> iterator, Description mismatchDescription) {
        Matching<E> matching = new Matching<>(matchers, mismatchDescription);
        while (iterator.hasNext()) {
            if (!matching.matches(iterator.next())) {
                return false;
            }
        }

        return matching.isFinished(iterator);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("iterable over ")
                .appendList("[", ", ", "]", matchers)
                .appendText(" in any order");
    }

    private static class Matching<S> {
        private final Collection<Matcher<? super S>> matchers;
        private final Description mismatchDescription;

        public Matching(Collection<Matcher<? super S>> matchers, Description mismatchDescription) {
            this.matchers = new ArrayList<>(matchers);
            this.mismatchDescription = mismatchDescription;
        }

        public boolean matches(S item) {
            return isNotSurplus(item) && isMatched(item);
        }

        public boolean isFinished(Iterator<? extends S> iterator) {
            if (matchers.isEmpty()) {
                return true;
            }
            mismatchDescription
                    .appendText("No item matches: ").appendList("", ", ", "", matchers)
                    .appendText(" in specified iterator.");
            return false;
        }

        private boolean isNotSurplus(S item) {
            if (matchers.isEmpty()) {
                mismatchDescription.appendText("Not matched: ").appendValue(item);
                return false;
            }
            return true;
        }

        private boolean isMatched(S item) {
            for (Matcher<? super S> matcher : matchers) {
                if (matcher.matches(item)) {
                    matchers.remove(matcher);
                    return true;
                }
            }
            mismatchDescription.appendText("Not matched: ").appendValue(item);
            return false;
        }

    }

    /**
     * Creates a matcher for {@link Iterator}s that matches when a single pass over the
     * examined {@link Iterator} yields a single item that satisfies the specified matcher.
     * For a positive match, the examined iterator must only yield one item.
     *
     * @param itemMatcher the matcher that must be satisfied by the single item provided by an
     *                    examined {@link Iterator}
     * @deprecated use contains(Matcher<? super E> itemMatcher) instead
     */
    @SuppressWarnings("unchecked")
    @Deprecated
    @Factory
    public static <E> Matcher<Iterator<? extends E>> containsInAnyOrder(final Matcher<? super E> itemMatcher) {
        return containsInAnyOrder(new ArrayList<>(asList(itemMatcher)));
    }

    /**
     * Creates an order agnostic matcher for {@link Iterator}s that matches when a single pass over
     * the examined {@link Iterator} yields a series of items, each satisfying one matcher anywhere
     * in the specified matchers.  For a positive match, the examined iterator must be of the same
     * length as the number of specified matchers.
     *
     * @param itemMatchers a list of matchers, each of which must be satisfied by an item provided
     *                     by an examined {@link Iterator}
     */
    @Factory
    public static <T> Matcher<Iterator<? extends T>> containsInAnyOrder(Matcher<? super T>... itemMatchers) {
        return containsInAnyOrder(Arrays.asList(itemMatchers));
    }

    /**
     * Creates an order agnostic matcher for {@link Iterator}s that matches when a single pass over
     * the examined {@link Iterator} yields a series of items, each logically equal to one item
     * anywhere in the specified items. For a positive match, the examined iterator
     * must be of the same length as the number of specified items.
     *
     * @param items the items that must equal the items provided by an examined {@link Iterator} in any order
     */
    @Factory
    public static <T> Matcher<Iterator<? extends T>> containsInAnyOrder(T... items) {
        List<Matcher<? super T>> matchers = new ArrayList<>();
        for (T item : items) {
            matchers.add(equalTo(item));
        }

        return new IsIteratorContainingInAnyOrder<>(matchers);
    }

    /**
     * Creates an order agnostic matcher for {@link Iterator}s that matches when a single pass over
     * the examined {@link Iterator} yields a series of items, each satisfying one matcher anywhere
     * in the specified collection of matchers.  For a positive match, the examined iterator
     * must be of the same length as the specified collection of matchers.
     *
     * @param itemMatchers a list of matchers, each of which must be satisfied by an item provided
     *                     by an examined {@link Iterator}
     */
    @Factory
    public static <T> Matcher<Iterator<? extends T>> containsInAnyOrder(Collection<Matcher<? super T>> itemMatchers) {
        return new IsIteratorContainingInAnyOrder<>(itemMatchers);
    }
}
