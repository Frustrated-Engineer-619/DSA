package com.dsa.graph.dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    private int[] dist;
    private Queue<Pair> pq;

    public Dijkstra(int noOfVertex, int srcNode) {
        dist = new int[noOfVertex];
        pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[srcNode] = 0;
        pq.add(new Pair(srcNode, 0));
    }

    public int[] findShortestPath(List<List<Pair>> graph) {
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int distance = current.distance;
            int node = current.node;

            // Ignore stale entries
            if (distance > dist[node]) {
                continue;
            }

            for (Pair edge : graph.get(node)) {
                int neighbor = edge.node;
                int weight = edge.distance;

                if (distance + weight < dist[neighbor]) {
                    dist[neighbor] = distance + weight;
                    pq.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }
        return dist;
    }

}
