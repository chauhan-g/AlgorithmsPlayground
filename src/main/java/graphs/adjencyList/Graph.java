package graphs.adjencyList;

//TODO: Use vertex class to represent Vertexes as given in book Data Structures made easy in Java.
public class Graph {
    int noOfVertexes;
    boolean[][] adjMatrix;

    Graph(int noOfVertexes) {
        this.noOfVertexes = noOfVertexes;
        this.adjMatrix = new boolean[noOfVertexes][noOfVertexes];
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = true;
        //for undirected graph
        adjMatrix[destination][source] = true;
    }

    public void removeEdge(int source, int destination) {
        adjMatrix[source][destination] = false;
        //for undirected graph
        adjMatrix[destination][source] = false;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < noOfVertexes; i++) {
            for (int j = 0; j < noOfVertexes; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
