package graphs.disjointSet.dynamic;

public class Vertex {
    private int data;
    private int rank;

    public Vertex(int data) {
        this.data = data;
        //Important:make the vertex parent of itself
        this.parent = this;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    private Vertex parent;

}
