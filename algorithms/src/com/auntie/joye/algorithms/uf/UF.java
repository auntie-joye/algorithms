package com.auntie.joye.algorithms.uf;

/**
 * Contract for union-find algorithm implementations.
 */
public interface UF {
    /**
     * @return number of separate components.
     */
    int count();

    /**
     * finds the root node for the passed child node identifier.
     * @param p child node identifier.
     * @return root node identifier.
     */
    int find(int p);

    /**
     * Unions two separate components by identifiers of their nodes.
     * @param p node identifier from one component.
     * @param q node identifier from another component.
     */
    void union(int p, int q);

    /**
     * @param p node identifier from one component.
     * @param q node identifier from another component.
     * @return true if two separate components are connected, otherwise - false.
     */
    boolean connected(int p, int q);
}
