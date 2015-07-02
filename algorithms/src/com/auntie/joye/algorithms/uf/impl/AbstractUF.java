package com.auntie.joye.algorithms.uf.impl;

import com.auntie.joye.algorithms.uf.UF;

/**
 * Base implementation of {@link UF} w/o details.
 */
public abstract class AbstractUF implements UF {
    /**
     * Structure to represent nodes and connections between them.
     */
    protected int[] id;
    /**
     * Number of separate components.
     */
    protected int count;

    public AbstractUF(int n) {
        id = new int[n];
        count = n;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
