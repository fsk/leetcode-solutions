package com.fsk.algorithms.graph;

// Main sınıfı
public class Main {
    public static void main(String[] args) {
        Graph1<Integer> graph = new Graph1<>();

        // Kenarlar ekleniyor (örnek olarak)
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);

        // Grafı yazdır
        graph.printGraph();
    }
}
