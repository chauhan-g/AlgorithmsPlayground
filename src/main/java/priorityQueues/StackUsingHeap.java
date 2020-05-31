package priorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingHeap {
    public int size;
    private PriorityQueue<Element> priorityQueue;
    //TODO the integer value might not be sufficient for comparison when overflow(adding and removing but always increasing the priority), so use time instant.
    private int priority;

    StackUsingHeap() {
        this.size = 0;
        //(IMPORTANT): the comparision operation.
        this.priorityQueue = new PriorityQueue<>(Comparator.comparing(Element::getInsertCount));
        this.priority = 0;
    }

    //(IMPORTANT): see the return type is boolean.Can use add to throw exception in size bounded queue
    public boolean push(int value) {
        size++;
        return priorityQueue.offer(new Element(value, ++priority));
    }

    //(IMPORTANT): Can use remove to throw exception when queue is empty instead of returning null.
    public Element pop() {
        size--;
        return priorityQueue.poll();
    }

    public Element peek() {
        return priorityQueue.peek();
    }

    //TODO: generate this as a generic class
    private class Element {
        private int value;
        private final int insertCount;

        public Element(int value, int insertCount) {
            this.value = value;
            this.insertCount = insertCount;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getInsertCount() {
            return insertCount;
        }
    }

    public static void main(String[] args) {
        StackUsingHeap queue = new StackUsingHeap();

        queue.push(2);
        queue.push(3);
        queue.push(6);
        queue.push(7);
        queue.push(11);
        queue.push(13);
        queue.push(43);

        while (queue.size > 0)
            System.out.println(queue.pop().getValue());
    }
}
