package priorityQueues;

import java.lang.reflect.Array;
import java.util.Arrays;

//TODO: do the same when comitting the sorting algorithms
public class HeapSort {

    public int[] sort(int[] array) {
        return new BinaryHeap().heapSort(array);
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 51, 6, 7, 99};

        int[] output = new HeapSort().sort(input);

        for (int value : output) {
            System.out.println(value);
        }
    }
}
