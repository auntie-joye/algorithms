package com.auntie.joye.algorithms.uf.impl;

import org.junit.Test;

import static com.auntie.joye.algorithms.uf.impl.UFAssert.*;

public class QuickUnionUFTest {
    @Test
    public void testInitializationCountReturnsNumberOfComponents() {
        int expected = 3;
        QuickUnionUF uf = new QuickUnionUF(expected);

        assertUFCount(uf, expected);
    }

    @Test
    public void testInitializationEachNodeIsParentOfItself() {
        QuickUnionUF uf = new QuickUnionUF(5);

        assertUFStructure(uf.id, 0, 1, 2, 3, 4);
    }

    @Test
    public void testUnionConnectsNodes() {
        QuickUnionUF uf = new QuickUnionUF(5);
        uf.union(2,3);

        assertUFConnected(uf, 2, 3);
        assertUFStructure(uf.id, 0, 1, 3, 3, 4);
    }

    @Test
    public void testUnionDecreaseCountByOne() {
        QuickUnionUF uf = new QuickUnionUF(5);
        uf.union(2, 3);

        assertUFConnected(uf, 2, 3);
        assertUFCount(uf, 4);
    }

    @Test
    public void testStructureAfterSeveralUnionCalls() {
        QuickUnionUF uf = new QuickUnionUF(5);
        uf.union(2,3);
        uf.union(2,4);
        uf.union(4,1);
        uf.union(3,0);

        assertUFStructure(uf.id, 0, 0, 3, 4, 1);
        assertUFCount(uf, 1);
    }
}