package com.codingthrough.algorithms.adt.stack.challenges;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Unit tests for {@link BracketBalance}.
 */
public class BracketBalanceTest {
    @Test
    public void throwsWhenReverseNullArray() {
        final String s = null;

        try {
            BracketBalance.isBalanced(s);
            fail("Should throw when check null string object");
        } catch (IllegalArgumentException e) {
            // ok, it's expected exception
        }
    }

    @Test
    public void returnsTrueWhenCheckEmptyString() {
        final String s = "";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(true));
    }

    @Test
    public void returnsTrueWhenCheckStringWithOneNonBracketSymbol() {
        final String s = "A";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(true));
    }

    @Test
    public void returnsTrueWhenCheckStringWithSeveralNonBracketSymbols() {
        final String s = "ABC";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(true));
    }

    @Test
    public void returnsTrueWhenCheckStringWithBalancedPairs() {
        final String s = "(){}{([]())}";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(true));
    }

    @Test
    public void returnsFalseWhenCheckStringWithCloseBracketsInReverseOrder() {
        final String s = "([)]";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(false));
    }

    @Test
    public void returnsFalseWhenCheckStringWithMissedCloseBracket() {
        final String s = "([]";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(false));
    }

    @Test
    public void returnsFalseWhenCheckStringWithMissedOpenBracket() {
        final String s = "(])";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(false));
    }

    @Test
    public void skipsNonBracketSymbols() {
        final String s = "(A){}{(A[B](B))}";

        final boolean actual = BracketBalance.isBalanced(s);
        assertThat(actual, is(true));
    }
}
