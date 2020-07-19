package graphs.adjencyList.shortestPaths;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

//TODO: Practise again and add Important Comments.
//TODO: add parent array to know the path as well.
public class DijkstrasAlgorithm {
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

    static void singleSourceShortestPath(Graph g) {
        int[] distance = new int[g.vertexes]; //used for storing the result,i.e actual distance.
        boolean[] inSPT = new boolean[g.vertexes]; ////Important :to check if vertex is already included in shortest path traversed.
        PQVertex[] pqVertices = new PQVertex[g.vertexes]; //Important : used for update(add/ remove) keys in PQ
        TreeSet<PQVertex> pq = new TreeSet<>(Comparator.comparing(PQVertex::getWeight));

        //Important : initial setup to make 0 as start of Dijkstras algorithm.
        PQVertex start = new PQVertex(0, 0);
        pq.add(start);
        distance[0] = 0;
        pqVertices[0] = start;

        for (int i = 1; i < g.vertexes; i++) {
            PQVertex pqVertex = new PQVertex(i, Integer.MAX_VALUE - i); //Important : (Integer.MAX_VALUE - destination.vertex) Hack Treeset does not allow same weight of MAX value.
            pqVertices[i] = pqVertex;
            distance[i] = Integer.MAX_VALUE;
            pq.add(pqVertex);
        }

        while (!pq.isEmpty()) {
            PQVertex currentVertex = pq.pollFirst();
            inSPT[currentVertex.vertex] = true;

            for (Vertex destination : g.adjList[currentVertex.vertex]) {

                if (!inSPT[destination.vertex]) {//Important
                    //Important : (Integer.MAX_VALUE - destination.vertex)Hack Treeset does not allow same weight of MAX value
                    //Important : destination.weight + distance[currentVertex.vertex] < distance[destination.vertex]...distance array is used,not PQVertices
                    if (Integer.MAX_VALUE - destination.vertex != distance[destination.vertex] &&
                            destination.weight + distance[currentVertex.vertex] < distance[destination.vertex]) {
                        //Important : (Integer.MAX_VALUE - destination.vertex)Hack Treeset does not allow same weight of MAX value

                        //Important : PQVertex and its array is used to remove the vertex easily from Treeset
                        //Important : Below are important steps; Remove->Update->Add; just for updating the keys in PQ.
                        //Important : Remove
                        pq.remove(pqVertices[destination.vertex]);
                        //Important : Update the Array, so that next removal is also successful
                        pqVertices[destination.vertex].weight = destination.weight + currentVertex.weight;
                        //Important : Add
                        pq.add(pqVertices[destination.vertex]);

                        //Important :Update the distance array.
                        distance[destination.vertex] = destination.weight + currentVertex.weight;
                    }
                }
            }
        }

        for (int i = 1; i < g.vertexes; i++) {
            System.out.println("Minimum distance between 0 and " + i + " is =" + distance[i]);
        }
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

        singleSourceShortestPath(graph);
    }
}
