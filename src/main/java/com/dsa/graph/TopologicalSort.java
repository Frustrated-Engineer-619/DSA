package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Topological Sort (Directed Graph):
 * <p>
 * We need the edges of the graph
 * Calculate the indegree of the nodes.
 * Just add the nodes to the queue with indegree == 0
 * Just pick the node form teh queue and make the connected nodes indegree--
 * if indegree went to 0 just add it.
 * <p>
 * And maintain the dependency Result.
 * <p>
 * if the result size == Number of nodes in a graph. that means cycle doesn't exist in teh graph.
 *
 */


public class TopologicalSort {

    private int[] indegree;
    private Queue<Integer> queue;
    private int n;
    private List<List<Integer>> graph;


    public TopologicalSort(List<Edge> edgeList, int n) {
        indegree = new int[n];
        queue = new LinkedList<>();
        graph = new ArrayList<>();
        this.n = n;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        edgeList.forEach(edge -> {
            int from = edge.getU();
            int to = edge.getV();
            graph.get(from).add(to);
            indegree[to]++;
        });
    }

    public List<Integer> findTopologicalOrder() {
        List<Integer> order = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (indegree[node] == 0) {
                order.add(node);
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighborNode : graph.get(node)) {
                indegree[neighborNode]--;
                if (indegree[neighborNode] == 0) {
                    order.add(neighborNode);
                    queue.add(neighborNode);
                }
            }
        }
        return order;
    }


}
