package com.auntie.joye.algorithms.uf.impl;

import com.auntie.joye.algorithms.uf.UF;

/**
 * Implementation of {@link UF} with quick union with weighted optimization approach.
 */
public class WeightedQuickUnionUF extends QuickFindUF {
    protected int[] sz;

    public WeightedQuickUnionUF(int n) {
        super(n);

        sz = new int[n];
        for(int i=0; i < n; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if(idP != idQ) {
            if(sz[idP] <= sz[idQ]) {
                id[idP] = idQ;
                sz[idQ] += sz[idP];
            } else {
                id[idQ] = idP;
                sz[idP] += sz[idQ];
            }

            count--;
        }
    }
}
