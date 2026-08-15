package com.dsa.graph;

public class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u) return u;
        return parent[u] = findParent(parent[u]);
    }

    public void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (rank[u] > rank[v]) {
            parent[v] = u;
        } else if (rank[v] > rank[u]) {
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public boolean connected(int u, int v) {
        return findParent(u) == findParent(v);
    }

}
