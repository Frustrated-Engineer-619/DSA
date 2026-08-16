package com.dsa.graph;

public class Edge {
    private final int u;
    private final int v;

    public Edge(int from, int to) {
        this.u = from;
        this.v = to;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }
}
