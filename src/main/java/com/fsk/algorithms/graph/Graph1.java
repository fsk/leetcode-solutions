package com.fsk.algorithms.graph;

import java.util.*;

public class Graph1<T> {
    private Map<T, List<T>> adjList; // Komşuluk listesi

    // Constructor
    public Graph1() {
        adjList = new HashMap<>();
    }

    // Bir kenar ekler
    public void addEdge(T source, T dest, boolean bidirectional) {
        /**
         * Bu satırlar, source (kaynak) ve dest (hedef) düğümlerinin
         * adjList içinde olup olmadığını kontrol eder.
         */
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        adjList.get(source).add(dest);
        if (bidirectional) {
            adjList.get(dest).add(source);
        }
    }

    // Bir düğümün komşularını getirir
    public List<T> getNeighbors(T vertex) {
        return adjList.get(vertex);
    }

    // Grafı yazdırır
    public void printGraph() {
        for (T vertex : adjList.keySet()) {
            System.out.println("Düğüm " + vertex + " komşuları: " + adjList.get(vertex));
        }
    }
}

