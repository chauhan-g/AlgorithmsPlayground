package graphs.adjencyList.shortestPaths;

public class FloydWarshallAlgorithm {
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
        int V;  //Important: For matrix.
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
            edges[source] = new Edge(source, destination, weight); //Important: Directed edge.
        }
    }


    static void allPairShortestPath(Graph g) {
        int[][] distance = new int[g.V][g.V]; //Important: Represents the distance between vertex i and j.
        int[][] parent = new int[g.V][g.V]; //Important: Represents the distance between vertex i and j.

        for (int i = 0; i < g.V; i++) {
            for (int j = 0; j < g.V; j++) {
                parent[i][j] = Integer.MAX_VALUE;//Important:No one is parent of other initially


                if (i != j) {//Important: distance from self to self is 0.
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //Important:update distance matrix and parent matrix based on the edges.
        for (Edge e : g.edges) {
            int source = e.source;
            int destination = e.destination;
            int weight = e.weight;

            distance[source][destination] = weight;
            parent[source][destination] = source;
        }


        for (int k = 0; k < g.V; k++) { //Important: Represents intermediate vertex
            for (int i = 0; i < g.V; i++) { //Important: i,j represent the distance matrix
                for (int j = 0; j < g.V; j++) {

                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE //Important:Good to check if there is edege or not
                            && (distance[i][k] + distance[k][j] < distance[i][j])) {//Important: If there is a path through k vertex that is cheap, then use it.

                        distance[i][j] = distance[i][k] + distance[k][j];

                        parent[i][j] = k; //Important: update the parent for j, i.e destination because there is a cheaper path from k.
                    }
                }
            }
        }

        printSolution(distance, g.V);

        printParents(parent, g.V);
    }

    static void printSolution(int dist[][], int V) {
        System.out.println("The following matrix shows the shortest " +
                "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    static void printParents(int parent[][], int V) {
        System.out.println("The following matrix shows the Parents::::");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (parent[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(parent[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /* Let us create the following weighted graph

           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3

       */

        int V = 4; // Number of vertices in graph
        int E = 4; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;
        graph.edges[0].weight = 5;

        // add edge 1-2 (or B-C in above figure)
        graph.edges[1].source = 1;
        graph.edges[1].destination = 2;
        graph.edges[1].weight = 3;

        // add edge 1-4
        graph.edges[2].source = 1;
        graph.edges[2].destination = 3;
        graph.edges[2].weight = 10;

        // add edge 2-3
        graph.edges[3].source = 2;
        graph.edges[3].destination = 3;
        graph.edges[3].weight = 1;


        allPairShortestPath(graph);
//        int V = 5; // Number of vertices in graph
//        int E = 8; // Number of edges in graph
//
//        Graph graph = new Graph(V, E);
//
//        // add edge 0-1 (or A-B in above figure)
//        graph.edges[0].source = 0;
//        graph.edges[0].destination = 1;
//        graph.edges[0].weight = -1;
//
//        // add edge 0-2 (or A-C in above figure)
//        graph.edges[1].source = 0;
//        graph.edges[1].destination = 2;
//        graph.edges[1].weight = 4;
//
//        // add edge 1-2 (or B-C in above figure)
//        graph.edges[2].source = 1;
//        graph.edges[2].destination = 2;
//        graph.edges[2].weight = 3;
//
//        // add edge 1-3 (or B-D in above figure)
//        graph.edges[3].source = 1;
//        graph.edges[3].destination = 3;
//        graph.edges[3].weight = 2;
//
//        // add edge 1-4 (or A-E in above figure)
//        graph.edges[4].source = 1;
//        graph.edges[4].destination = 4;
//        graph.edges[4].weight = 2;
//
//        // add edge 3-2 (or D-C in above figure)
//        graph.edges[5].source = 3;
//        graph.edges[5].destination = 2;
//        graph.edges[5].weight = 5;
//
//        // add edge 3-1 (or D-B in above figure)
//        graph.edges[6].source = 3;
//        graph.edges[6].destination = 1;
//        graph.edges[6].weight = 1;
//
//        // add edge 4-3 (or E-D in above figure)
//        graph.edges[7].source = 4;
//        graph.edges[7].destination = 3;
//        graph.edges[7].weight = -3;
//
//        allPairShortestPath(graph);
    }

}



