package graphs.adjencyList.mst;

import priorityQueues.BinaryMaxHeap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//TODO: Practise again and add Important Comments.Code Clean as well.
public class PrimsAlgorithmUsingCustomBH {
    private class PQVertex {
        int vertex;
        int key;

        public PQVertex(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    private class BinaryHeap {
        int capacity;
        int size;
        PQVertex[] heapArray;
        int[] pos;

        public BinaryHeap(int capacity) {
            this.capacity = capacity;
            this.size = -1;
            this.heapArray = new PQVertex[capacity];
            this.pos = new int[capacity];
        }

        public void insert(PQVertex pqVertex) {
            if (++size >= capacity) {
                resizeHeap();
            }

            heapArray[size] = pqVertex;
            pos[pqVertex.vertex] = size;

            bubbleUp(pqVertex, size);
        }

        private void bubbleUp(PQVertex pqVertex, int index) {
            int current = index;
            int parent = getParentIndex(current);
            while (parent >= 0 && (heapArray[parent].key > pqVertex.key)) {
                heapArray[current] = heapArray[parent];
                pos[heapArray[current].vertex] = current;
                current = parent;
                parent = getParentIndex(current);
            }

            heapArray[current] = pqVertex;
            pos[pqVertex.vertex] = current;
        }

        public int getParentIndex(int childIndex) {
            if (childIndex <= 0 || childIndex > capacity) return -1;

            return (childIndex - 1) / 2;
        }

        private void resizeHeap() {
            heapArray = Arrays.copyOf(heapArray, capacity * 2);
        }

        public PQVertex delete() {
            if (size < 0) {
                System.out.println("Empty priority Queue");
                return null;
            }

            PQVertex deletedVertex = heapArray[0];
            heapArray[0] = heapArray[size];
            pos[heapArray[0].vertex] = 0;
            size--;

            bubbleDown(0);

            return deletedVertex;
        }

        private void bubbleDown(int index) {
            if (index < 0 || index > size) {
                return;
            }

            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int max = index;

            if (leftChild < size && heapArray[index].key >= heapArray[leftChild].key) {
                max = leftChild;
            }

            if (rightChild < size && heapArray[max].key >= heapArray[rightChild].key) {
                max = rightChild;
            }

            if (max != index) {
                //Swap
                PQVertex temp = heapArray[max];
                heapArray[max] = heapArray[index];
                heapArray[index] = temp;

                pos[heapArray[max].vertex] = max;
                pos[heapArray[index].vertex] = index;

                bubbleDown(max);
            }
        }

        public boolean isEmpty() {
            if (size >= 0) return false;
            else return true;
        }
    }

    private static class DestinationVertex {
        int destination;
        int weight;

        DestinationVertex(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Graph {
        private int vertexes;
        private List<DestinationVertex>[] adjList;

        Graph(int vertexes) {
            this.vertexes = vertexes;
            this.adjList = new List[vertexes];
            for (int i = 0; i < vertexes; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            adjList[source].add(new DestinationVertex(destination, weight));
            adjList[destination].add(new DestinationVertex(source, weight));
        }
    }

    public void mst(Graph graph) {
        PQVertex start = new PQVertex(0, 0);
        BinaryHeap heap = new BinaryHeap(graph.vertexes);
        boolean[] inMST = new boolean[graph.vertexes];
        int[] parent = new int[graph.vertexes];

        heap.insert(start);

        for (int i = 1; i < graph.vertexes; i++) {
            heap.insert(new PQVertex(i, Integer.MAX_VALUE));
        }

        while (!heap.isEmpty()) {
            PQVertex currentVertex = heap.delete();
            inMST[currentVertex.vertex] = true;

            for (DestinationVertex dv : graph.adjList[currentVertex.vertex]) {
                if (inMST[dv.destination] == false) {
                    PQVertex dvInHeap = heap.heapArray[heap.pos[dv.destination]];

                    if (dv.weight < dvInHeap.key) {
                        dvInHeap.key = dv.weight;
                        heap.bubbleUp(dvInHeap, heap.pos[dv.destination]);
                        parent[dv.destination] = currentVertex.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int o = 1; o < graph.vertexes; o++)
            System.out.println(parent[o] + " "
                    + "-"
                    + " " + o);
    }

    public static void main(String[] args) {
        int V = 9;

        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);



//        int V = 5;
//        Graph graph = new Graph(V);
//
//        graph.addEdge(0, 1, 2);
//        graph.addEdge(0, 2, 5);
//        graph.addEdge(1, 2, 2);
//        graph.addEdge(1, 3, 4);
//        graph.addEdge(1, 4, 4);
//        graph.addEdge(2, 4, 4);

//        int V = 5;
//        Graph graph = new Graph(V);
//
//        graph.addEdge(0, 1, 1);
//        graph.addEdge(0, 4, 2);
//        graph.addEdge(0, 2, 4);
//        graph.addEdge(1, 2, 2);
//        graph.addEdge(1, 3, 8);
//        graph.addEdge(2, 3, 1);
//        graph.addEdge(2, 4, 1);


        // Method invoked
        PrimsAlgorithmUsingCustomBH primsAlgorithm = new PrimsAlgorithmUsingCustomBH();

        primsAlgorithm.mst(graph);
    }
}
