package graphs.adjencyList.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public List<Integer> getBFS(Graph graph) {
        int n = graph.noOfVertexes;
        List<Integer> bfs = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfs.add(current);

            for (int i : graph.adjList.get(current)) {
                if (isVisited[i] == false) {
                    queue.offer(i);
                    isVisited[i] = true; //Important: mark visited here not outside.
                }
            }

        }

        return bfs;
    }

    public static void main(String[] args) {
//              Graph:
//
//                0
//                |
//                1
//               / \
//              2   4
//             /    \
//            3      5
//           /      /
//          7     6
//         /     /
//        8     11
//       /
//      10

        Graph g = new Graph(12);

        g.addEdge(0, 1);
//        g.addEdge(0, 2); //Important: used it to check isVisited.
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 11);
        g.addEdge(3, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 10);
//        g.addEdge(1, 4);
//        g.addEdge(2, 5);
//        g.addEdge(5, 6);

        //new DepthFirstSearch().getDFS(g).forEach(System.out::println);

        new BreadthFirstSearch().getBFS(g).forEach(System.out::println);
    }
}
