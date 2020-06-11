package graphs.adjencyList.topologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//TODO: keep track of vertexes in graph using vertex array or use Vertex class.
public class KahnAlgorithm {
    // No. of vertices
    private int V;

    private ArrayList<ArrayList<Integer>> adj;

    KahnAlgorithm(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    List<Integer> topologicalSort() {
        int vertexProcessed = 0;//Important: to check cycle
        int[] indegree = new int[V];//Important: keeps indegree of each vertex.

        for (int i = 0; i < V; i++) {
            for (int destination : adj.get(i)) {
                indegree[destination]++;
            }
        }

        LinkedList<Integer> topologicalSort = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();//important:using queue for processing.Also,no visited array required.

        //Important:First insert all the vertexes having indegree 0.Most corner cases covered with this step.
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topologicalSort.add(currentVertex);
            vertexProcessed++;

            for (int adjVertex : adj.get(currentVertex)) {
                if (--indegree[adjVertex] == 0) {//Important: decrease the indegree of adj vertexes and add to queue if 0.Check the changing indegree with Debug.
                    queue.offer(adjVertex);
                }
            }
        }

        if (vertexProcessed != V) {
            System.out.println("Graph contains a cycle");
            return Collections.emptyList();
        }

        return topologicalSort;
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


//        KahnAlgorithm g = new KahnAlgorithm(6);
//        g.addEdge(5, 2);
//        g.addEdge(5, 0);
//        g.addEdge(4, 0);
//        g.addEdge(4, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);

        KahnAlgorithm g = new KahnAlgorithm(5);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.addEdge(4, 1);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 3);


        //Important: look at the wiki for another graph example.
        //Important: look at the wiki for another graph example.
        System.out.println("Topological sort of the given graph is:");

        g.topologicalSort().forEach(it -> System.out.print(it + " "));
    }
}
