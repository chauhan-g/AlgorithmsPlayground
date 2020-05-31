package disjointSet.dynamic;


public class DisjointSetWithPathCompressionUnionByRank {
    /***
     *
     * @param vertex
     * @return the subset to which the vertex belongs
     */
    public Vertex find(Vertex vertex) {
        //Important: Visualize it.
        //Important: check if the vertex is parent of itself
        if (vertex != vertex.getParent()) {
            //Important: Path compression.
            vertex.setParent(find(vertex.getParent()));
        }

        return vertex.getParent();
    }

    /***
     * find the subset of each vertex and assign one of them as a parent of other based on rank.
     *
     * @param v1
     * @param v2
     */
    public void union(Vertex v1, Vertex v2) {
        Vertex v1Representative = find(v1);
        Vertex v2Representative = find(v2);

        //Important: Union by rank
        //Important:see https://www.geeksforgeeks.org/disjoint-set-data-structures/ for more information.
        if (v1Representative.getRank() < v2Representative.getRank()) {
            v1Representative.setParent(v1Representative);
        } else if (v1Representative.getRank() > v2Representative.getRank()) {
            v2Representative.setParent(v1Representative);
        } else {
            v1Representative.setParent(v2Representative);
            v2Representative.setRank(v2Representative.getRank() + 1);
        }
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

        DisjointSetWithPathCompressionUnionByRank ds = new DisjointSetWithPathCompressionUnionByRank();

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

        //check again the previous vertexes
        System.out.println(ds.find(v5).getData());
        System.out.println(ds.find(v0).getData());
        System.out.println(ds.find(v2).getData());
        System.out.println(ds.find(v1).getData());

        //checking path compression done or not.Change the temp
        Vertex temp = v3;
        Vertex tempParent = v7;
        while (temp != tempParent) {
            System.out.println("checking path compression done or not");
            System.out.println(temp.getData());
            temp = temp.getParent();
        }
    }
}
