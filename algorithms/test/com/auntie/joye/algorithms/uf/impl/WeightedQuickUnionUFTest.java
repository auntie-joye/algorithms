package com.auntie.joye.algorithms.uf.impl;

import org.junit.Test;

import static com.auntie.joye.algorithms.uf.impl.UFAssert.*;

public class WeightedQuickUnionUFTest {
    @Test
    public void testInitializationCountReturnsNumberOfComponents() {
        int expected = 3;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(expected);

        assertUFCount(uf, expected);
    }

    @Test
    public void testInitializationEachNodeIsParentOfItself() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);

        assertUFStructure(uf.id, 0, 1, 2, 3, 4);
    }

    @Test
    public void testUnionConnectsNodes() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);
        uf.union(2,3);

        assertUFConnected(uf, 2, 3);
        assertUFStructure(uf.id, 0, 1, 3, 3, 4);
    }

    @Test
    public void testUnionDecreaseCountByOne() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);
        uf.union(2, 3);

        assertUFConnected(uf, 2, 3);
        assertUFCount(uf, 4);
    }

    @Test
    public void testUnionChangesTreeSizes() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);
        uf.union(2, 3);

        assertUFConnected(uf, 2, 3);
        assertUFStructure(uf.sz, 1, 1, 1, 2, 1);
    }

    @Test
    public void testStructureAfterSeveralUnionCalls() {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);
        uf.union(2,3);
        uf.union(2,4);
        uf.union(4,1);
        uf.union(3,0);

        assertUFStructure(uf.id, 3, 3, 3, 3, 3);
        assertUFStructure(uf.sz, 1,1,1,5,1);
        assertUFCount(uf, 1);
    }
}