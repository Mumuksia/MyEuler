package com.euler.utils.graphs;


import org.junit.Test;

public class AdjacencyMatrix {

    int[][] adjMatrix;
    int[] result;
    int[] visited;

    @Test
    public void doTest() {
        adjMatrix = new int[][]{{0, 7, 9, 0, 0, 14}, {7, 0, 10, 15, 0, 0}, {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0}, {0, 0, 0, 6, 0, 9}, {14, 0, 2, 0, 9, 0}};

        countPaths();
        for (int aResult : result) {
            System.out.println(aResult);
        }

    }

    public void countPaths() {
        result = new int[adjMatrix.length];
        visited = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            visited[i] = -1;
            result[i] = -1;
        }
        result[0] = 0;
        setWeights(0);
    }

    public void setWeights(int node) {
        for (int i = 0; i < result.length; i++) {
            if (adjMatrix[node][i] != 0 && visited[i] != 1 && (result[i] > (result[node] + adjMatrix[node][i]) ||
                    result[i] == -1))
                result[i] = result[node] + adjMatrix[node][i];
        }
        visited[node] = 1;
        int res = getMinimum();
        if (res == -1) return;
        setWeights(res);
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
}
