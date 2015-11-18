package com.codingthrough.algorithms.adt.stack.challenges;

import com.codingthrough.algorithms.Preconditions;
import com.codingthrough.algorithms.adt.stack.LinkedStack;
import com.codingthrough.algorithms.adt.stack.Stack;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * Checks that the specified string contains all brackets in balance, in other
 * words - every open bracket has closed bracket in the correct order.
 * E.g.
 * {([])} - balanced
 * {()[}] - not balanced
 * Note: other characters besides brackets will be skipped during analysis.
 */
public class BracketBalance {
    public static boolean isBalanced(@Nonnull String s) {
        Preconditions.ensureNotNull(s);

        Stack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (brackets.containsKey(ch)) {
                stack.push(ch);
            } else if (brackets.containsValue(ch)) {
                if (!stack.empty() && ch == brackets.get(stack.pop())) {
                    continue;
                }
                return false;
            }
        }

        return stack.empty();
    }

    private static Map<Character, Character> brackets;

    static {
        brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
    }
}
