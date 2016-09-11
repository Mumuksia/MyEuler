package com.euler.utils.graphs;

import org.junit.Test;

import java.util.List;


public class Dejkstra {

    AdjacencyList adjList;

    //assume nodes are from 0.1.2...
    private int[] result;
    private int[] visited;

    @Test
    public void doTest() {
        adjList = init();
        fillinresult();
        setWeights(new Node(0));
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public void setWeights(Node root) {
        System.out.println("Visited nodes " + root.name);
        List<Edge> edges = AdjacencyList.getAdjacent(root);
        for (Edge edge : edges) {
            if (result[edge.getTo().name] == -1 || result[edge.getTo().name] > (edge.weight + result[root.name]))
                result[edge.getTo().name] = edge.weight + result[root.name];
        }
        visited[root.name] = 1;
        int res = getMinimum();
        if (res == -1) return;
        setWeights(new Node(res));
    }

    public int getMinimum() {
        int res = -1;
        int min = -1;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1 && visited[i] != 1 && (result[i] < min || min == -1)) {
                min = result[i];
                res = i;
            }
        }
        return res;
    }


    public AdjacencyList init() {
        AdjacencyList adjList = new AdjacencyList();
        adjList.addEdge(new Node(0), new Node(1), 7);
        adjList.addEdge(new Node(0), new Node(2), 9);
        adjList.addEdge(new Node(0), new Node(5), 14);
        adjList.addEdge(new Node(1), new Node(2), 10);
        adjList.addEdge(new Node(1), new Node(3), 15);
        adjList.addEdge(new Node(1), new Node(0), 7);
        adjList.addEdge(new Node(2), new Node(3), 11);
        adjList.addEdge(new Node(2), new Node(5), 2);
        adjList.addEdge(new Node(2), new Node(0), 9);
        adjList.addEdge(new Node(3), new Node(4), 6);
        adjList.addEdge(new Node(3), new Node(1), 15);
        adjList.addEdge(new Node(4), new Node(5), 9);
        adjList.addEdge(new Node(4), new Node(3), 6);
        adjList.addEdge(new Node(5), new Node(0), 14);
        adjList.addEdge(new Node(5), new Node(2), 2);
        adjList.addEdge(new Node(5), new Node(4), 9);
        return adjList;
    }

    public void fillinresult() {
        result = new int[adjList.getSourceNodeSet().size()];
        visited = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
            visited[i] = 0;
        }
        result[0] = 0;
    }


}
