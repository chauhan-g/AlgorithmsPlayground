package graphs.adjencyList.scc;

import java.util.*;

//Important:
// Steps 1. DFS : to store vertexes in stack with decreasing finish times.
// Steps 2. Transpose graph.
// Steps 3. Do dfs on transposed graph.
public class KosarajuAlgorithm {
    static class Graph {
        int V;
        List<Integer> adj[];

        Graph(int V) {
            this.V = V;
            this.adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adj[source].add(destination); //Important : SCC needs for directed edges.
        }
    }

    private void dfs(Graph g, int vertex, boolean[] visited, Stack<Integer> s) {
        visited[vertex] = true;
        for (int adjVertex : g.adj[vertex]) {
            if (visited[adjVertex] == false) {
                dfs(g, adjVertex, visited, s);
            }
        }

        s.push(vertex); //Important :
    }

    private void dfs2(Graph g, int vertex, boolean[] visited) {
        System.out.print(vertex + " ");

        visited[vertex] = true;//Important

        for (int adjVertex : g.adj[vertex]) {
            if (visited[adjVertex] == false) {
                dfs2(g, adjVertex, visited);
            }
        }
    }

    private Graph transpose(Graph g) {
        Graph transposedGraph = new Graph(g.V);

        for (int i = 0; i < g.V; i++) {
            Iterator<Integer> l = g.adj[i].iterator();
            while (l.hasNext()) {
                transposedGraph.adj[l.next()].add(i);
            }
        }

        return transposedGraph;
    }

    void stronglyConnectedComponents(Graph g) {
        int n = g.V;
        boolean[] visited = new boolean[n];
        //Important : only stack is something new in this dfs traversal,other parameters are normal dfs traversal.
        Stack<Integer> s = new Stack<>();

        //Important : Step 1: DO dfs to store the vertexes in stack according to their finish time in dfs,
        // i.e push vertex to stack only after dfs traversal of its adj.This makes sure that
        // the vertex that connects to other scc will always be popped first in dfs traversal of transposed graph.
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(g, i, visited, s);
            }
        }

        //Important : Step 2 : Do transpose of original graph.
        Graph transposedGraph = transpose(g);

        Arrays.fill(visited, false);

        //Important : Step 3 : while stack is not empty, do dfs.
        while (!s.isEmpty()) {
            //Important : pop and then check if visited or not before doing dfs, because the vertex in stack might have already been part of other SCC.
            int vertex = s.pop();

            if (visited[vertex] == false) {//Important : do dfs only if vertex is not visited,
                // because if it is already visited,then it means that they have already been covered in other SCC.
                dfs2(transposedGraph, vertex, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram

        //Important ; why storing vertexes in stack,i.e why storing vertexes based on their finish time of dfs:
        //The important point to note is DFS may produce a tree or a forest
        // when there are more than one SCCs depending upon the chosen starting point.
        // For example, in the above diagram, if we start DFS from vertices 0 or 1 or 2,
        // we get a tree as output. And if we start from 3 or 4, we get a forest.
        // To find and print all SCCs, we would want to start DFS from vertex 4 (which is a sink vertex),
        // then move to 3 which is sink in the remaining set (set excluding 4) and finally any of the remaining vertices (0, 1, 2).
        //So how do we find this sequence of picking vertices as starting points of DFS?
        // Unfortunately, there is no direct way for getting this sequence.
        // However, if we do a DFS of graph and store vertices according to their finish times,
        // we make sure that the finish time of a vertex that connects to other SCCs (other that its own SCC),
        // will always be greater than finish time of vertices in the other SCC
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        new KosarajuAlgorithm().stronglyConnectedComponents(g);
    }

}
