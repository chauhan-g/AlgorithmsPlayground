package priorityQueues;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] input = {2, 5, 11, 33, 1234, 1, 9, 7};
        int k = 4;
        int result = new KthSmallestElement().getKthSmallest(input, k);

        System.out.println("The Kth largest element is :" + result);
    }

    private int getKthSmallest(int[] input, int k) {
        if (k <= 0 || k > input.length) {
            System.out.println("wrong input");
            return -1;
        }

        BinaryMinHeap heap = new BinaryMinHeap(input.length).buildHeap(input);

        for (int i = 1; i < k; i++) {
            int deleted = heap.delete();
            System.out.println("deleted :" + deleted);
        }

        return heap.heapArray[0];
    }
}
