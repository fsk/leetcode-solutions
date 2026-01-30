package com.fsk.denemeler;

import java.util.*;

// Kenar sınıfı
class Edge {
    int dest;
    int weight;

    // Constructor
    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + dest + ", ağırlık: " + weight + ")";
    }
}

// Graf sınıfı
public class AgirlikliGraph {
    private Map<Integer, List<Edge>> adjList; // Ağırlıklı komşuluk listesi

    // Constructor
    public AgirlikliGraph() {
        adjList = new HashMap<>();
    }

    // Bir kenar ekler
    public void addEdge(int source, int dest, int weight, boolean bidirectional) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(new Edge(dest, weight));

        if (bidirectional) {
            adjList.putIfAbsent(dest, new ArrayList<>());
            adjList.get(dest).add(new Edge(source, weight)); // Çift yönlü için aynı ağırlık kullanılır
        }
    }

    // Bir düğümün komşularını ve kenar ağırlıklarını getirir
    public List<Edge> getNeighbors(int vertex) {
        return adjList.get(vertex);
    }

    // Grafı yazdırır
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.println("Düğüm " + vertex + " komşuları ve ağırlıkları: " + adjList.get(vertex));
        }
    }
}

// Main sınıfı
class Main {
    public static void main(String[] args) {
        AgirlikliGraph graph = new AgirlikliGraph();

        // Kenarlar ve ağırlıkları ekleniyor (örnek olarak)
        graph.addEdge(0, 1, 5, true);
        graph.addEdge(0, 4, 9, true);
        graph.addEdge(1, 2, 3, true);
        graph.addEdge(1, 3, 4, true);
        graph.addEdge(1, 4, 2, true);
        graph.addEdge(2, 3, 1, true);
        graph.addEdge(3, 4, 7, true);

        // Grafı yazdır
        graph.printGraph();
    }
}
