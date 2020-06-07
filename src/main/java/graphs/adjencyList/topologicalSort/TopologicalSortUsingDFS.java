package graphs.adjencyList.topologicalSort;
// A Java program to print topological
// sorting of a DAG

import java.util.ArrayList;
import java.util.Stack;

//TODO: handle cycle.
//TODO: keep track of vertexes in graph using vertex array or use Vertex class.
public class TopologicalSortUsingDFS {
    // No. of vertices
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSortUsingDFS(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void topologicalSortUtil(
            int v, boolean[] visited,
            Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;

        //Important: Recur for all the vertices adjacent vertexes if not visited.
        for (int adjVertex : adj.get(v)) {
            if (visited[adjVertex] == false) {
                topologicalSortUtil(adjVertex, visited, stack);
            }
        }

        //Important: Note that push is done after processing adj vertexes.
        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++)
            visited[i] = false;

        //Important: iterating for every vertex.Can use another array to keep track of vertexes available.
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        //Important:Stack itself contains the result to be printed.
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String[] args) {
//              Graph:
//
//                5     4
//               / \   /\
//              /   \ /  \
//             2     0    1
//              \        /
//               \      /
//                 \   /
//                   3


        TopologicalSortUsingDFS g = new TopologicalSortUsingDFS(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        //Important: look at the wiki for another graph example.
        System.out.println("Topological sort of the given graph is:");
        g.topologicalSort();
    }
}