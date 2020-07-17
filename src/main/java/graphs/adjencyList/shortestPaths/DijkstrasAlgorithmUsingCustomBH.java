package graphs.adjencyList.shortestPaths;

import java.util.LinkedList;
import java.util.List;

//TODO(LATER)
//TODO: Practise again and add Important Comments.
public class DijkstrasAlgorithmUsingCustomBH {
    private static class Graph {
        int vertexes;
        List<Vertex>[] adjList;

        Graph(int vertexes) {
            this.vertexes = vertexes;
            adjList = new LinkedList[vertexes];
            for (int i = 0; i < vertexes; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination, int weight) {
            adjList[source].add(new Vertex(destination, weight));
            adjList[destination].add(new Vertex(source, weight));
        }
    }

    private static class Vertex {
        int vertex;
        int weight;

        Vertex(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    //Important : used for update(add/ remove) keys in PQ
    private static class PQVertex {
        int vertex;
        int weight;

        PQVertex(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    static void shortestPath(Graph g) {
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

        shortestPath(graph);
    }
}
