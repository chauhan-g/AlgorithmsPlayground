package disjointSet.dynamic;


public class DisjointSet {
    /***
     *
     * @param vertex
     * @return the subset to which the vertex belongs
     */
    public Vertex find(Vertex vertex) {
        //Important: check if the vertex is parent of itself
        if (vertex == vertex.getParent()) return vertex;

        return find(vertex.getParent());
    }

    /***
     * find the subset of each vertex and assign one of them as a parent of other.
     *
     * @param v1
     * @param v2
     */
    public void union(Vertex v1, Vertex v2) {
        Vertex vertex1Representative = find(v1);
        Vertex vertex2Representative = find(v2);

        //Important: Make the parent of vertex1’s representative
        // be vertex2’s  representative effectively
        // moving all of vertex1’s set into vertex2’s set)
        vertex1Representative.setParent(vertex2Representative);
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);

        DisjointSet ds = new DisjointSet();

        ds.union(v1, v2);
        ds.union(v2, v0);
        ds.union(v0, v5);

        System.out.println(ds.find(v5).getData());
        System.out.println(ds.find(v0).getData());
        System.out.println(ds.find(v2).getData());
        System.out.println(ds.find(v1).getData());


        ds.union(v6, v7);
        ds.union(v7, v3);

        System.out.println(ds.find(v6).getData());
        System.out.println(ds.find(v7).getData());
        System.out.println(ds.find(v3).getData());

        System.out.println(ds.find(v5).getData());
        System.out.println(ds.find(v0).getData());
        System.out.println(ds.find(v2).getData());
        System.out.println(ds.find(v1).getData());

        //checking path compression done or not
        while (v5 != v1) {
            System.out.println("checking path compression done or not");
            System.out.println(v1.getData());
            v1 = v1.getParent();
        }
        //ds.union(-1, 9);
    }
}
