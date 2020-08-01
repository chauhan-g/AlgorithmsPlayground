package graphs.adjencyList.dfsApplications;

import java.util.LinkedList;
import java.util.List;

public class CutEdgesOrCutBridges {
    static class Graph {
        private int V; // No. of vertices
        private List<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w); // Add w to v's list.
            adj[w].add(v); //Add v to w's list
        }
    }

    int time = 0; //Important : to keep track of discovery time in dfs

    private void cutBridgesUtil(Graph graph, int vertex, boolean[] visited, int[] dfsNum, int[] low, int[] parent) {
        visited[vertex] = true; //Important :

        dfsNum[vertex] = ++time; //Important
        low[vertex] = ++time; //Important

        for (int adjVertex : graph.adj[vertex]) {
            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (visited[adjVertex] == false) {
                parent[adjVertex] = vertex; //Important : mark parent

                //Important : recur for adjacent vertex
                cutBridgesUtil(graph, adjVertex, visited, dfsNum, low, parent);

                //Important : Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                //i.e if adjacent vertex can reach ancestor, then current vertex can also reach ancestor from its adjacent vertex.
                low[vertex] = Math.min(low[vertex], low[adjVertex]);

                //Important : The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]”.
                if (low[adjVertex] > low[vertex]) {
                    System.out.println(vertex + " " + adjVertex + " is a cut bridge");
                }

            }
            //Important : Update low value of u for parent function calls.
            else if (adjVertex != parent[vertex]) {
                //Important : we use dfsnum of adjacent vertex not low,
                // because this is what that is reachable from adjacent vertex.(Do manual debug of first graph in main to understand better)
                low[vertex] = Math.min(low[vertex], dfsNum[adjVertex]);
            }
        }
    }

    public void cutBridges(Graph graph) {
        int n = graph.V;
        boolean[] visited = new boolean[n];

        //Important : below three extra arrays other than dfs visited array is needed here.
        int[] dfsNum = new int[n]; //Important :keeps tracks of when when the vertex occurs in dfs traversal. (discovery time of vertex in dfs)
        int[] low = new int[n]; //Important : lowest ancestor vertex that could be reachable from the subtree rooted at vertex. (backedge)
        int[] parent = new int[n]; //Important : Stores parent vertices in DFS tree.Used for checking
        // if the adjacent vertex that is already visited is not a parent of vertex
        //i.e we are not coming from parent vertex and this adjacent vertex is already visited, so this is a back edge and we could reach ancestors from it


        for (int i = 0; i < n; i++) {
            //Important : run dfs for every vertex that is not visited.
            if (visited[i] == false) {
                cutBridgesUtil(graph, i, visited, dfsNum, low, parent);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Bridges in first graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        new CutEdgesOrCutBridges().cutBridges(g1);
        System.out.println();

        System.out.println("Bridges in Second graph");
        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        new CutEdgesOrCutBridges().cutBridges(g2);
        System.out.println();

        System.out.println("Bridges in Third graph ");
        Graph g3 = new Graph(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        new CutEdgesOrCutBridges().cutBridges(g2);
    }
}
