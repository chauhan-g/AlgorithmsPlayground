package graphs.adjencyList.traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Graph {
    int noOfVertexes;
    List<List<Integer>> adjList;

    Graph(int noOfVertexes) {
        this.noOfVertexes = noOfVertexes;
        adjList = new LinkedList<>();

        IntStream.rangeClosed(1, noOfVertexes).forEach(i ->
                adjList.add(new LinkedList<>()));
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        //for undirected graph
        adjList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination) {
        adjList.get(source).remove(destination);
        //for undirected graph
        adjList.get(destination).remove(source);
    }

    public void printAdjacencyList() {
        adjList.forEach(list -> {
            list.forEach(System.out::print);

            System.out.println();
        });
    }
}
