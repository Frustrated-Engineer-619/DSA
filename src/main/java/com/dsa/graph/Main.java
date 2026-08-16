package com.dsa.graph;

import com.dsa.graph.topologicalsort.Edge;
import com.dsa.graph.topologicalsort.TopologicalSort;

import java.util.List;

public class Main {
    static void main(String[] args) {
        List<Edge> edgeList = List.of(
                new Edge(0, 1),
                new Edge(1, 2),
                new Edge(2, 3),
                new Edge(3, 0),
                new Edge(4, 3)
        );

        TopologicalSort topologicalSort = new TopologicalSort(edgeList, 5);
        System.out.println(topologicalSort.findTopologicalOrder());

        topologicalSort.findTopologicalOrder()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
