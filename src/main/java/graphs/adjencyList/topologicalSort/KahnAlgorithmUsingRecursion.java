package graphs.adjencyList.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TODO: keep track of vertexes in graph using vertex array or use Vertex class.
public class KahnAlgorithmUsingRecursion {
    // No. of vertices
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    KahnAlgorithmUsingRecursion(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }


    List<Integer> topologicalSort() {
        LinkedList<Integer> topologicalSort = new LinkedList<>();
        boolean[] isVisited = new boolean[V];
        int[] indegree = new int[V];

        //Important:Calculate the indegree
        for (int vertex = 0; vertex < V; vertex++) {
            for (int destination : adj.get(vertex)) {
                indegree[destination]++;
            }
        }

        //call the util function that actually finds the topological sort
        topologicalSortUtil(indegree, isVisited, topologicalSort);

        return topologicalSort;
    }

    void topologicalSortUtil(int[] indegree, boolean[] isVisited, LinkedList<Integer> topologicalSort) {
        //Important: base condition
        if (topologicalSort.size() == V) return;//Important: all the vertexes traversed,so return

        //TODO:Think about proper way to indicate the cycle.Below code is not reachable
//        if (topologicalSort.size() > V) { //Not needed
//            System.out.println("graph contains cycle");
//            return;
//        }

        //Important:Loop for each vertex
        for (int vertex = 0; vertex < V; vertex++) {
            if (indegree[vertex] == 0 && isVisited[vertex] == false) {//Important
                topologicalSort.add(vertex);
                isVisited[vertex] = true;

                for (int destination : adj.get(vertex)) {
                    indegree[destination]--;//Important:Decrease the indegree(i.e remove the edges of adj vertexes).Also,not doing recursion here
                }

                //Important:recursion is done here.
                //So, we again loop for each vertex in recursion and current vertex's adj vertexes already have decreased indegree.
                //Analyse in Debug Mode.
                topologicalSortUtil(indegree, isVisited, topologicalSort);
            }
        }
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


        KahnAlgorithmUsingRecursion g = new KahnAlgorithmUsingRecursion(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

//        KahnAlgorithmUsingRecursion g = new KahnAlgorithmUsingRecursion(5);
//        g.addEdge(4, 0);
//        g.addEdge(4, 2);
//        g.addEdge(4, 1);
//        g.addEdge(0, 1);
//        g.addEdge(2, 1);
//        g.addEdge(0, 3);
//        g.addEdge(2, 3);


        //Important: look at the wiki for another graph example.
        //Important: look at the wiki for another graph example.
        System.out.println("Topological sort of the given graph is:");

        g.topologicalSort().forEach(it -> System.out.print(it + " "));
    }
}
