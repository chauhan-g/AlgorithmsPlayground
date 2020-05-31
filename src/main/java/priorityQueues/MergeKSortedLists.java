package priorityQueues;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class MergeKSortedLists {
    public List<Integer> mergeKSortedLists(List<ListNode> lists) {
        //Important: Need the comparator for comparison
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), Comparator.comparing(ListNode::getValue));

        //Important: Inserting just the head of all the lists
        for (ListNode node : lists) {
            if (null != node)
                pq.offer(node);
        }

        List<Integer> result = new ArrayList<>();

//Important: Steps:
// 1.Pop the top and put it into the result
// 2.Increment(i.e move to next element of current popped) and Insert the next node of the popped in pq
// TODO: Do this using the ListNode itself instead of using List for result
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            result.add(current.getValue());
            current = current.getNext();

            if (null != current)
                pq.offer(current);
        }

        return result;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(5, new ListNode(9)));
        ListNode list2 = new ListNode(2, new ListNode(6, new ListNode(10)));
        ListNode list3 = new ListNode(3, new ListNode(7, new ListNode(11)));
        ListNode list4 = new ListNode(4, new ListNode(8, new ListNode(12)));

        List<ListNode> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        List<Integer> result = new MergeKSortedLists().mergeKSortedLists(lists);

        result.forEach(System.out::println);
    }


}

//Important: using this for the next.
class ListNode {
    private int value;
    private ListNode next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

