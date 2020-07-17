package graphs.adjencyList.topologicalSort;

import java.util.ArrayList;

//TODO(LATER)
//TODO: keep track of vertexes in graph using vertex array or use Vertex class.
public class AllTogologicalSort {
    // No. of vertices
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    AllTogologicalSort(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    //TODO:Practice it later again.

    /***
     * Important: The algorithm is almost same like Kahn Algorithm(recursive),except we reset the values after recursion for getting other Topological sort.
     */
    void topologicalSort() {
//        LinkedList<Integer> topologicalSort = new LinkedList<>();
//        int[] indegree = new int[V];
//        boolean[] isVisited = new boolean[V];
//
//        for (int vertex = 0; vertex < V; vertex++) {
//            for (int destination : adj.get(vertex)) {
//                indegree[destination]++;
//            }
//        }
//
//        topologicalSortUtil(indegree, isVisited, topologicalSort);
//
    }

//    private void topologicalSortUtil(int[] indegree, boolean[] isVisited, LinkedList<Integer> topologicalSort) {
//        if (topologicalSort.size() > V) {
//            System.out.println("graph contains cycle");
//            return;
//        }
//        if (topologicalSort.size() == V) {
//            topologicalSort.forEach(vertex -> System.out.print(vertex + " "));
//            System.out.println();
//        }
//
//        for (int vertex = 0; vertex < V; vertex++) {
//            if (indegree[vertex] == 0 && isVisited[vertex] == false) {
//                isVisited[vertex] = true;
//                topologicalSort.add(vertex);
//
//                for (int adjVertex : adj.get(vertex)) {
//                    indegree[adjVertex]--;//Important:not doing recursion here
//                }
//
//                topologicalSortUtil(indegree, isVisited, topologicalSort);
//
//                //Reset values for current vertex for backtracking
//                isVisited[vertex]=false;
//                topologicalSort.removeLast();
//
//                for (int adjVertex : adj.get(vertex)) {
//                    indegree[adjVertex]++;
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
//              Graph:
//
//                5     4
//               / \   /\
//              /   \ /  \
//             2     0    1
//              \        /^
//               \      /
//                 \   /
//                   3


        AllTogologicalSort g = new AllTogologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

//        AllTogologicalSort g = new AllTogologicalSort(5);
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

        g.topologicalSort();

        //    g.topologicalSort().forEach(it -> System.out.print(it + " "));
    }
}
