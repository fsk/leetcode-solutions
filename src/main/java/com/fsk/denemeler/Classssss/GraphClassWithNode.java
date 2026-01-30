package com.fsk.denemeler.Classssss;


import java.util.ArrayList;
import java.util.List;

// Kenar sınıfı
class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

// Düğüm (Node) sınıfı
class Node {
    int value;
    List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.edges = new ArrayList<>();
    }

    // Bu düğümden başka bir düğüme kenar ekler
    public void addEdge(Node target, int weight) {
        edges.add(new Edge(target, weight));
    }
}

// Graf sınıfı
class Graph {
    List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    // Yeni bir düğüm ekler ve bu düğümü döndürür
    public Node addNode(int value) {
        Node node = new Node(value);
        nodes.add(node);
        return node;
    }

    // Grafı yazdırır
    public void printGraph() {
        for (Node node : nodes) {
            System.out.print("Düğüm " + node.value + " komşuları: ");
            for (Edge edge : node.edges) {
                System.out.print("(" + edge.target.value + ", ağırlık: " + edge.weight + ") ");
            }
            System.out.println(); // Yeni satır
        }
    }
}

// Main sınıfı
public class GraphClassWithNode {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Düğümleri ekleyin
        Node node0 = graph.addNode(0);
        Node node1 = graph.addNode(1);
        Node node2 = graph.addNode(2);
        Node node3 = graph.addNode(3);
        Node node4 = graph.addNode(4);

        // Kenarları ekleyin
        node0.addEdge(node1, 5);
        node0.addEdge(node4, 9);
        node1.addEdge(node2, 3);
        node1.addEdge(node3, 4);
        node1.addEdge(node4, 2);
        node2.addEdge(node3, 1);
        node3.addEdge(node4, 7);

        // Grafı yazdır
        graph.printGraph();
    }
}


