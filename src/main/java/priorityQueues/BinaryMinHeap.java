package priorityQueues;

import java.util.Arrays;

public class BinaryMinHeap {
    public int[] heapArray;
    public int capacity; // size of heap
    public int count;    // number of elements in heap

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public BinaryMinHeap() {
        this(DEFAULT_CAPACITY);
        Arrays.fill(this.heapArray, Integer.MAX_VALUE);
    }

    public BinaryMinHeap(int capacity) {
        this.capacity = capacity;
        this.heapArray = new int[capacity];
        Arrays.fill(this.heapArray, Integer.MAX_VALUE);//(IMPORTANT)
    }

    public int getParentIndex(int childIndex) {
        if (childIndex <= 0 || childIndex > capacity) return -1;

        return (childIndex - 1) / 2;
    }

    public int getLeftChildIndex(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;

        if (leftChildIndex < 0 || leftChildIndex >= count) return -1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int parentIndex) {
        int rightChildIndex = 2 * parentIndex + 2;

        if (rightChildIndex < 0 || rightChildIndex >= count) return -1;//(IMPORTANT) : checking with count.

        return rightChildIndex;
    }

    private void bubbleDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int min;

        if (-1 != leftChildIndex && heapArray[leftChildIndex] < heapArray[index]) min = leftChildIndex;
        else min = index;

        if (-1 != rightChildIndex && heapArray[rightChildIndex] < heapArray[min]) min = rightChildIndex;

        if (min != index) {
            //(IMPORTANT): Swap
            int temp = heapArray[index];
            heapArray[index] = heapArray[min];
            heapArray[min] = temp;

            //(IMPORTANT): calling inside if
            bubbleDown(min);
        }
    }

    /***
     * Removes/Deletes the top of heap.
     *
     *This method  replaces the root element with the last element of heap.
     * Use bubbleDown/percolateDown to satisfy heap invariant again.
     *
     * @return the root/top element of heap
     */
    public int delete() {
        if (count <= 0) return -1;

        int root = heapArray[0];

        heapArray[0] = heapArray[count - 1];
        count--; //(IMPORTANT) : reducing the heap size.

        bubbleDown(0);

        return root;
    }

    public void insert(int data) {
        if (++count >= heapArray.length) resizeHeap();

        int currentIndex = count;
        int parentIndex = getParentIndex(currentIndex);

        //bubbleUP
        //(IMPORTANT) : check the bubble up operation
        while (parentIndex >= 0 && heapArray[parentIndex] > data) {
            heapArray[currentIndex] = heapArray[parentIndex];
            currentIndex = parentIndex;
            parentIndex = getParentIndex(currentIndex);
        }
//        while (index > 0 && heapArray[(index - 1) / 2] > data) {
//            heapArray[index] = heapArray[(index - 1) / 2];
//            index = (index - 1) / 2;
//        }

        heapArray[currentIndex] = data;
    }

    /***
     * Important:
     * Heapifying the array.
     * The elements form N/2 to N-1 are leaf nodes and each node is a 1 element heap.So we dont need to heapify them.
     *
     * Since most the nodes are the leaf nodes and we are not heapfiying them, the complexity would be O(n) instead of O(nlogn)
     *
     * @param array
     */
    public BinaryMinHeap buildHeap(int[] array) {
        this.capacity = this.count = array.length;
        this.heapArray = array;

        for (int index = (count - 1) / 2; index >= 0; index--) {
            bubbleDown(index);
        }

        return this;
    }

    public void destroy() {
        heapArray = null;
        count = 0;
    }

    public int[] heapSort(int[] array) {
        buildHeap(array);

        for (int i = array.length - 1; i >= 0; i--) {
            //delete the top element from heap
            //place the top element from heap
            // just bubble down to maintain heap invariant.
            //(IMPORTANT) : 1.We just decrease the count of elements in heap array not the capacity.So, we can store the element at last.
            //              2.It is just like Delete method.So,can use just delete() method as whole as an alternative below:

            int temp = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = temp;
            count--;


            bubbleDown(0);
        }

        return this.heapArray;
    }

    private void resizeHeap() {
        //Taken from java classes
        grow(count + 1);
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = heapArray.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        heapArray = Arrays.copyOf(heapArray, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public static void main(String[] args) {
        BinaryMinHeap heap = new BinaryMinHeap();
        heap.insert(5);
        heap.insert(4);
        heap.insert(10);
        heap.insert(0);
        heap.insert(3);
        heap.insert(2);
        heap.insert(12);

        Arrays.stream(heap.heapArray).forEach(System.out::println);
    }
}
