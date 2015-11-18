package com.codingthrough.algorithms.sort;

import java.util.Comparator;

/**
 * Created by aunti_000 on 18.11.2015.
 */
public class SortSupportTest {
    protected class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a == null && b == null) {
                return 0;
            }

            if (a == null) {
                return -1;
            }

            if (b == null) {
                return 1;
            }

            return a.compareTo(b);
        }
    }
}
