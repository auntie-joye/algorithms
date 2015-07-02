package com.auntie.joye.algorithms.uf.impl;

import com.auntie.joye.algorithms.uf.UF;

/**
 * Implementation of {@link UF} with quick find approach.
 */
public class QuickFindUF extends AbstractUF {
    public QuickFindUF(int n) {
        super(n);

        for(int i=0; i < n; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);

        if(idP != idQ) {
            for(int i=0; i<id.length; i++) {
                if(id[i] == idP) {
                    id[i] = idQ;
                }
            }

            count--;
        }
    }
}
