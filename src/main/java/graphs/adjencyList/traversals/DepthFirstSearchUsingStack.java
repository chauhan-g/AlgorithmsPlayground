package graphs.adjencyList.traversals;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchUsingStack {
    public List getDFSUsingStack(Graph graph, int root) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> dfs = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.noOfVertexes];

        stack.push(root);
        isVisited[root] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            dfs.add(current);

//            //Important: Stack may contain same vertex twice. So
//            // we need to print the popped item only
//            // if it is not visited.
//            if (isVisited[current] == false) {
//                isVisited[current] = true;
//                dfs.add(current);
//            }

            for (int adjVertex : graph.adjList.get(current)) {
                if (isVisited[adjVertex] == false) {
                    stack.push(adjVertex);
                    isVisited[adjVertex] = true; //Important: marking it visited here so that we dont have to use above commented code.
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
//            3   -   5
//           /      / \
//          7     6    9
//         /     /
//        8     11
//       /
//      10

        Graph g = new Graph(12);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(1, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(6, 11);
        g.addEdge(3, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 10);

//        g.addEdge(5, 11);
//        g.addEdge(7, 11);
//        g.addEdge(7, 8);
//        g.addEdge(3, 8);
//        g.addEdge(3, 10);
//        g.addEdge(8, 9);
//        g.addEdge(11, 9);
//        g.addEdge(11, 2);

//        g.addEdge(1, 4);
//        g.addEdge(2, 5);
//        g.addEdge(5, 6);

        new DepthFirstSearchUsingStack().getDFSUsingStack(g, 0).forEach(it -> System.out.print(it + " "));

        //g.printAdjacencyList();
    }
}
