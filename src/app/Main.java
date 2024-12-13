package app;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.availableAddVertex(1);
        graph.availableAddVertex(2);
        graph.availableAddVertex(3);
        graph.availableAddVertex(4);

        graph.availableAddEdge(1,2);
        graph.availableAddEdge(2,3);
        graph.availableAddEdge(3,4);

        System.out.println("\nПочатковий граф: ");
        graph.printGraph();

        System.out.println("\nЧи існує вершина 2? " + graph.availableHasVertex(2) +
                "\nЧи існує вершина 9? " + graph.availableHasVertex(9));

        System.out.println("\nЧи існує ребро між вершинами 1 та 2? " + graph.availableHasEdge(1,2) +
                "\nЧи існує ребро між вершинами 1 та 3? " + graph.availableHasEdge(1,3));

        graph.availableRemoveEdge(3,4);
        System.out.println("\nГраф після видалення ребра між вершинами 3 та 4: ");
        graph.printGraph();

        graph.availableRemoveVertex(2);
        System.out.println("\nГраф після видалення вершини 2: ");
        graph.printGraph();
    }
}
