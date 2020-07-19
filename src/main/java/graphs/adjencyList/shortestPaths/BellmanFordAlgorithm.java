package graphs.adjencyList.shortestPaths;

public class BellmanFordAlgorithm {
    static class Edge {
        int source, destination, weight;

        Edge() {
            this.source = this.destination = this.weight = 0;
        }

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;  //Important : We need to take all edges v-1 times because the shortest path to last vertex will have v-1 edges.
        int E;  //Important : We take array of edges
        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            this.edges = new Edge[E]; //Important
            for (int i = 0; i < E; i++) {
                edges[i] = new Edge();
            }
        }

        void addEdge(int source, int destination, int weight) {
            edges[source] = new Edge(source, destination, weight); //Important: Directed edge, might contain negative edge cycle.
        }
    }


    static void singleSourceShortestPath(Graph g) {
        int[] distance = new int[g.V];
        int[] parent = new int[g.V];

        distance[0] = 0; //Important: initialize the source //TODO: could use source as input as well.
        parent[0] = 0;   //Important: Use for tracking the path that leads to shortest path for this vertex from source.

        for (int i = 1; i < g.V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //Important: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 0; i < g.V - 1; i++) { //Important: V-1 times
            for (int j = 0; j < g.E; j++) { //Important: E times, that all edges are considered.

                Edge e = g.edges[j];
                int source = e.source;
                int destination = e.destination;
                int weight = e.weight;

                if (distance[source] != Integer.MAX_VALUE //Important
                        && (distance[destination] > distance[source] + weight)) { //Important

                    distance[destination] = distance[source] + weight;
                    parent[destination] = source;
                }
            }
        }

        // Important: Same like inner loop of above.This is used to check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < g.E; j++) {
            Edge e = g.edges[j];
            int source = e.source;
            int destination = e.destination;
            int weight = e.weight;

            if (distance[source] != Integer.MAX_VALUE
                    && (distance[destination] > distance[source] + weight)) {

                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        for (int i = 1; i < g.V; i++) {
            System.out.println("Minimum distance between 0 and " + i + " is =" + distance[i]);
        }

        System.out.println("printing parents::::::::::");

        for (int i = 0; i < g.V; i++) {
            System.out.println("parent of" + i + " is = " + parent[i]);
        }

    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;
        graph.edges[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edges[1].source = 0;
        graph.edges[1].destination = 2;
        graph.edges[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edges[2].source = 1;
        graph.edges[2].destination = 2;
        graph.edges[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edges[3].source = 1;
        graph.edges[3].destination = 3;
        graph.edges[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edges[4].source = 1;
        graph.edges[4].destination = 4;
        graph.edges[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edges[5].source = 3;
        graph.edges[5].destination = 2;
        graph.edges[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edges[6].source = 3;
        graph.edges[6].destination = 1;
        graph.edges[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edges[7].source = 4;
        graph.edges[7].destination = 3;
        graph.edges[7].weight = -3;

        BellmanFordAlgorithm.singleSourceShortestPath(graph);
    }
}
