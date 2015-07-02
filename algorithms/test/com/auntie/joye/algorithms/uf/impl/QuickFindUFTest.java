package com.auntie.joye.algorithms.uf.impl;

import org.junit.Test;

import static com.auntie.joye.algorithms.uf.impl.UFAssert.assertUFConnected;
import static com.auntie.joye.algorithms.uf.impl.UFAssert.assertUFCount;
import static com.auntie.joye.algorithms.uf.impl.UFAssert.assertUFStructure;

public class QuickFindUFTest {
    @Test
    public void testInitializationCountReturnsNumberOfComponents() {
        int expected = 3;
        QuickFindUF uf = new QuickFindUF(expected);

        assertUFCount(uf, expected);
    }

    @Test
    public void testInitializationEachNodeIsParentOfItself() {
        QuickFindUF uf = new QuickFindUF(5);

        assertUFStructure(uf.id, 0, 1, 2, 3, 4);
    }

    @Test
    public void testUnionConnectsNodes() {
        QuickFindUF uf = new QuickFindUF(5);
        uf.union(2,3);

        assertUFConnected(uf, 2, 3);
        assertUFStructure(uf.id, 0, 1, 3, 3, 4);
    }

    @Test
    public void testUnionDecreaseCountByOne() {
        QuickFindUF uf = new QuickFindUF(5);
        uf.union(2,3);

        assertUFConnected(uf, 2, 3);
        assertUFCount(uf, 4);
    }

    @Test
    public void testStructureAfterSeveralUnionCalls() {
        QuickFindUF uf = new QuickFindUF(5);
        uf.union(2,3);
        uf.union(2,4);
        uf.union(4,1);
        uf.union(3,0);

        assertUFStructure(uf.id, 0, 0, 0, 0, 0);
        assertUFCount(uf, 1);
    }
}