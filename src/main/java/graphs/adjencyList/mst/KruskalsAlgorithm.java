package graphs.adjencyList.mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KruskalsAlgorithm {
    //Important: see the Vertex class not used for source and destination because the same task can be done by subset class.
    // We just use int as source and destination to keep it simple.
    private class Edge implements Comparable<Edge> {
        int source, destination, weight;

        // Comparator function used for sorting edges
        // based on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    //Important : Represent the set.Used for keeping track of which vertex belongs to which set.Uses rank for Union by rank.
    private class Subset {
        int parent, rank;
    }

    int vertexes;
    Edge[] edges;

    KruskalsAlgorithm(int vertexes, int edges) {
        this.vertexes = vertexes;
        this.edges = new Edge[edges];

        for (int i = 0; i < edges; ++i)
            this.edges[i] = new Edge();
    }

    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge();
        edge.source = source;
        edge.destination = destination;
        edge.weight = weight;
    }

    //Important : find the set of current vertex.Passing current vertex's set and vertex itself because
    //the current vertex's set might have changed during union.
    int find(Subset subset, int vertex) {
        if (subset.parent != vertex) {
            subset.parent = find(subset, subset.parent); //Important : path compression
        }

        return subset.parent;
    }

    //Important : Union subset of source and destination based on Union by rank
    void union(Subset s1, Subset s2) {
        if (s1.rank < s2.rank) {
            s1.parent = s2.parent;
        } else if (s1.rank > s2.rank) {
            s2.parent = s1.parent;
        } else {
            s1.parent = s2.parent;
            s2.rank++;
        }
    }

    public List<Edge> mst() {
        List<Edge> mst = new LinkedList<>();
        Subset[] subsets = new Subset[vertexes];

        //Important : initialize the subsets
        for (int i = 0; i < vertexes; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;//Important :set self as parent.
            subsets[i].rank = 0;
        }

        Arrays.sort(edges);

        int edgeNumber = 0;//Important : used for getting the next edges from the sorted edges.

        while (mst.size() < vertexes - 1) {//Important : Number of edges in mst is V-1.
            Edge edge = edges[edgeNumber++];

            //Important : Just like the disjoint set Union-Find algorithm using path compression.
            //Find the set in which the vertex belongs.
            //if belong to same se then it means cycles, so discard it ,i.e dont go inside IF block below.
            //else go the If block and perform Union Operation and add edge to result.
            int sourceSubsetRepresentative = find(subsets[edge.source], edge.source);
            int destinationSubsetRepresentative = find(subsets[edge.destination], edge.destination);

            if (sourceSubsetRepresentative != destinationSubsetRepresentative) {
                union(subsets[edge.source], subsets[edge.destination]);
                mst.add(edge);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
               /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        KruskalsAlgorithm graph = new KruskalsAlgorithm(V, E);

        // add edge 0-1
        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].source = 0;
        graph.edges[1].destination = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].source = 0;
        graph.edges[2].destination = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].source = 1;
        graph.edges[3].destination = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].source = 2;
        graph.edges[4].destination = 3;
        graph.edges[4].weight = 4;


        for (Edge edge : graph.mst()) {
            System.out.println("source: " + edge.source + " destination: " + edge.destination + " weight: " + edge.weight);
        }

    }
}
