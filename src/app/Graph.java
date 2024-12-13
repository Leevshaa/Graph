package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    private void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    private void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    private void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            for (int neighbor : adjacencyList.get(vertex)) {
                adjacencyList.get(neighbor).remove(Integer.valueOf(vertex));
            }
            adjacencyList.remove(vertex);
        }
    }

    private void removeEdge(int source, int destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(Integer.valueOf(destination));
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(Integer.valueOf(destination));
        }
    }

    private boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    private boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Методи-обгортки для доступу до приватних методів
    public void availableAddVertex(int vertex) {
        addVertex(vertex);
    }

    public void availableAddEdge(int source, int destination) {
        addEdge(source, destination);
    }

    public void availableRemoveVertex(int vertex) {
        removeVertex(vertex);
    }

    public void availableRemoveEdge(int source, int destination) {
        removeEdge(source, destination);
    }

    public boolean availableHasVertex(int vertex) {
        return hasVertex(vertex);
    }

    public boolean availableHasEdge(int source, int destination) {
        return hasEdge(source, destination);
    }
}
