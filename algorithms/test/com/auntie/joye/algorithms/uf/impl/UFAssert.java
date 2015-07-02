package com.auntie.joye.algorithms.uf.impl;

import com.auntie.joye.algorithms.uf.UF;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Contains help assert functions to test {@link UF} implementations.
 */
public final class UFAssert {
    public static void assertUFStructure(int[] p, int... q) {
        assertEquals(p.length, q.length);

        for(int i=0;i<p.length;i++) {
            assertEquals(p[i], q[i]);
        }
    }

    public static void assertUFCount(UF uf, int expected) {
        assertEquals(expected, uf.count());
    }

    public static void assertUFConnected(UF uf, int p, int q) {
        assertTrue(uf.connected(p, q));
    }
}
