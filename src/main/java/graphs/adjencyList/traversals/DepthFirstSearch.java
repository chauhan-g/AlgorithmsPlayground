package graphs.adjencyList.traversals;


import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    public List getDFS(Graph graph, int root) {
        List<Integer> dfs = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.noOfVertexes];
//        for (int i = 0; i < graph.noOfVertexes; i++) { //Important: not needed
//            if (isVisited[i] == false) {
        getDFSUtil(graph, dfs, root, isVisited);
//            }
//        }

        return dfs;
    }

    private List getDFSUtil(Graph graph, List dfs, int vertex, boolean[] isVisited) {
        dfs.add(vertex);
        isVisited[vertex] = true;

        for (int adjVertex : graph.adjList.get(vertex)) {
            if (isVisited[adjVertex] == false) {
                getDFSUtil(graph, dfs, adjVertex, isVisited);
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

        new DepthFirstSearch().getDFS(g, 0).forEach(it -> System.out.print(it +" "));

        //g.printAdjacencyList();
    }
}
