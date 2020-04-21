package priorityQueues;

public class BinaryHeap {
    public int[] heapArray;
    public int capacity; // size of heap
    public int count;    // number of elements in heap
    public int heapType; // -1 for min heap and 1 for max heap

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_HEAP_TYPE = 1;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY, DEFAULT_HEAP_TYPE);
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
    }

    public BinaryHeap(int capacity, int heapType) {
        this.capacity = capacity;
        this.heapType = heapType;
    }

    public int getParentIndex(int childIndex) {
        if (childIndex < 0 || childIndex > capacity) return -1;

        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;

        if (leftChildIndex < 0 || leftChildIndex > capacity) return -1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int parentIndex) {
        int rightChildIndex = 2 * parentIndex + 2;

        if (rightChildIndex < 0 || rightChildIndex > capacity) return -1;

        return rightChildIndex;
    }
}
