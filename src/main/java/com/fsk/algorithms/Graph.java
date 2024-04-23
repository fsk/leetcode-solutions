package com.fsk.algorithms;

import java.util.*;

public class Graph<T> {

    private Map<T, List<T>> adjList = new HashMap<>();

    public void addEdge(T v, T w, boolean isDirected) {
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(v).add(w);

        if (!isDirected) {
            adjList.putIfAbsent(w, new ArrayList<>());
            adjList.get(w).add(v);
        }
    }

    public Iterable<T> adj(T v) {
        return adjList.getOrDefault(v, Collections.emptyList());
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        // Yönsüz graf için kenarlar ekleniyor
        graph.addEdge(0, 1, false);
        graph.addEdge(0, 4, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 4, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);

        // Grafın komşuluk listesini yazdır
        for (int v = 0; v < 5; v++) {
            System.out.print(v + ": ");
            for (int w : graph.adj(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }
}
