package graphs.adjencyList.traversals;

//TODO(LATER)
public class Vertex<T> {
    private T value;
    private boolean isVisited;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Vertex(T value, boolean isVisited) {
        this.value = value;
        this.isVisited = isVisited;
    }
}
