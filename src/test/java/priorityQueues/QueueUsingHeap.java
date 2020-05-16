package priorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueUsingHeap {
    public int size;
    private PriorityQueue<Element> priorityQueue;
    //TODO th integer value might not be sufficient for comparison when overflow(adding and removing but always increasing the priority), so use time instant.
    private int priority;

    QueueUsingHeap() {
        this.size = 0;
        //(IMPORTANT): the comparision operation has been reversed for queue.
        this.priorityQueue = new PriorityQueue<>(Comparator.comparing(Element::getInsertCount).reversed());
        this.priority = 0;
    }

    //(IMPORTANT): see the return type is boolean.Can use add to throw exception in size bounded queue
    public boolean offer(int value) {
        size++;
        return priorityQueue.offer(new Element(value, ++priority));
    }

    //(IMPORTANT): Can use remove to throw exception when queue is empty instead of returning null.
    public Element poll() {
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
        QueueUsingHeap queue = new QueueUsingHeap();

        queue.offer(2);
        queue.offer(3);
        queue.offer(6);
        queue.offer(7);
        queue.offer(11);
        queue.offer(13);
        queue.offer(43);

        while (queue.size > 0)
            System.out.println(queue.poll().getValue());
    }
}
