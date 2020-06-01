package graphs.adjencyMatrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public List<Integer> getBFS(Graph graph) {
        int n = graph.noOfVertexes;
        boolean[][] adjMatrix = graph.adjMatrix;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> bfs = new LinkedList();

        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();
                bfs.add(current);
                visited[current] = true;

                for (int j = 0; j < n; j++) {

                    if (visited[j] == false && adjMatrix[current][j] == true) {
                        queue.offer(j);
                    }
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

        new BreadthFirstSearch().getBFS(g).forEach(System.out::println);
    }
}
