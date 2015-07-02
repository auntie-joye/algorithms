package com.auntie.joye.algorithms.uf.impl;

import com.auntie.joye.algorithms.uf.UF;

/**
 * Implementation of {@link UF} with quick union approach.
 */
public class QuickUnionUF extends AbstractUF {
    public QuickUnionUF(int n) {
        super(n);

        for(int i=0; i < n; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public int find(int p) {
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if(idP != idQ) {
            id[idP] = idQ;
            count--;
        }
    }
}
