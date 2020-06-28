package graphs.adjencyList.mst;

import java.util.*;

public class PrimsAlgorithm {
    private static class DestinationVertex {
        int destination;
        int weight;

        DestinationVertex(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private class PQVertex {
        int vertex;
        int key;

        PQVertex(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getKey() {
            return key;
        }

    }

    private static class Graph {
        private int vertexes;
        private List<DestinationVertex>[] adjList;

        Graph(int vertexes) {
            this.vertexes = vertexes;
            this.adjList = new List[vertexes];
            for (int i = 0; i < vertexes; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            adjList[source].add(new DestinationVertex(destination, weight));
            adjList[destination].add(new DestinationVertex(source, weight));
        }
    }


    public void mst(Graph graph) {
        List<Integer> mst = new LinkedList<>();
        int[] parent = new int[graph.vertexes];
        boolean[] mstset = new boolean[graph.vertexes];
        PQVertex[] pqVertices = new PQVertex[graph.vertexes];
        TreeSet<PQVertex> pq = new TreeSet<>(Comparator.comparing(PQVertex::getKey));


        PQVertex startVertex = new PQVertex(0, 0);
        pqVertices[0] = startVertex;
        pq.add(startVertex);

        for (int i = 1; i < graph.adjList.length; i++) {
            PQVertex pqVertex = new PQVertex(i, Integer.MAX_VALUE - i);
            pqVertices[i] = pqVertex;
            pq.add(pqVertex);
        }

        while (!pq.isEmpty()) {
            PQVertex currentVertex = pq.pollFirst();
            mstset[currentVertex.vertex] = true;

            for (DestinationVertex destinationVertex : graph.adjList[currentVertex.vertex]) {
                if (mstset[destinationVertex.destination] == false) {
                    if (destinationVertex.weight < pqVertices[destinationVertex.destination].key) {
                        pq.remove(pqVertices[destinationVertex.destination]);
                        pq.add(new PQVertex(destinationVertex.destination, destinationVertex.weight));
                        pqVertices[destinationVertex.destination].key=destinationVertex.weight;
                        parent[destinationVertex.destination] = currentVertex.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int o = 0; o < graph.vertexes; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);
    }

    public static void main(String[] args) {
        int V = 9;

        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        // Method invoked
        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();

        primsAlgorithm.mst(graph);
    }
}
