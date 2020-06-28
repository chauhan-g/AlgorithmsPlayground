package priorityQueues;

import java.util.*;

public class SlidingWindowMaximum {
    //Important: this is required to keep track of index and delete the element from pq based on indexing
    class Element {
        private int value;
        private int index;

        public Element(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        //Important: important for deletion
        //TODO: Learn how to override equals and hash code like this.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return value == element.value &&
                    index == element.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int window = 3;

        List<Integer> result = new SlidingWindowMaximum().getSlidingWindowMaximum(input, window);

        result.forEach(System.out::println);
    }

    private List<Integer> getSlidingWindowMaximum(int[] input, int window) {
        //Important: See the comparison is reversed to get the maximum
        PriorityQueue<Element> pq = new PriorityQueue<>(window, Comparator.comparing(Element::getValue).reversed());
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (; i < window; i++) {
            pq.offer(new Element(input[i], i));
        }

        result.add(pq.peek().getValue());

        //Important: See how the variable i being used.
        while (i < input.length) {
            //Important: see pq remove method.It uses objects equals method.
            pq.remove(new Element(input[i - window], i - window));
            pq.offer(new Element(input[i], i));
            result.add(pq.peek().getValue());
            i++;
        }

        return result;
    }
}
