package graphs.adjencyList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    public List<Integer> getDFS(Graph graph) {
        int n = graph.noOfVertexes;
        boolean[][] adjMatrix = graph.adjMatrix;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> dfs = new LinkedList();

        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            dfs.add(current);
            visited[current] = true;

            for (int j = 0; j < n; j++) {

                if (visited[j] == false && adjMatrix[current][j] == true) {
                    stack.push(j);
                }
            }
        }

        return dfs;
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

        new DepthFirstSearch().getDFS(g).forEach(System.out::println);
    }
}
