package graphs.disjointSet.arrays;


public class DisjointSet {
    private int[] parent;
    public int vertex; //No of vertex

    public DisjointSet(int vertex) {
        this.vertex = vertex;
        this.parent = new int[vertex];

        //make each vertex as its own parent
        makeSet(vertex);
    }

    private void makeSet(int vertex) {
        for (int i = 0; i < vertex; i++) {
            this.parent[i] = i;
        }
    }

    /***
     *
     * @param vertex
     * @return the subset to which the vertex belongs
     */
    public int find(int vertex) throws Exception {
        validateVertex(vertex);
        if (parent[vertex] == vertex) {
            return vertex;
        }

        return find(parent[vertex]);
    }

    /***
     * find the subset of each vertex and assign one of them as a parent of other.
     *
     * @param vertex1
     * @param vertex2
     */
    public void union(int vertex1, int vertex2) throws Exception {
        validateVertex(vertex1, vertex2);
        int vertex1Representative = find(vertex1);
        int vertex2Representative = find(vertex2);

        //Important: Make the parent of vertex1’s representative
        // be vertex2’s  representative effectively
        // moving all of vertex1’s set into vertex2’s set)
        parent[vertex1Representative] = vertex2Representative;
    }

    private void validateVertex(int... vertexes) throws Exception {
        for (int vertex : vertexes) {
            if (vertex < 0 || vertex >= parent.length) {
                throw new Exception("invalid vertex " + vertex);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        DisjointSet ds = new DisjointSet(8);

        ds.union(1, 2);
        ds.union(2, 0);
        ds.union(0, 5);

        System.out.println(ds.find(5));
        System.out.println(ds.find(0));
        System.out.println(ds.find(2));
        System.out.println(ds.find(1));


        ds.union(6, 7);
        ds.union(7, 3);

        System.out.println(ds.find(6));
        System.out.println(ds.find(7));
        System.out.println(ds.find(3));

        System.out.println(ds.find(5));
        System.out.println(ds.find(0));
        System.out.println(ds.find(2));
        System.out.println(ds.find(1));

        //ds.union(-1, 9);

        System.out.println("printing parent array------->>>>//Important: This shows that tree height would be very large without Union by Rank and path compression");
        for (int parentVertex : ds.parent) {
            System.out.println(parentVertex);
        }
    }
}
