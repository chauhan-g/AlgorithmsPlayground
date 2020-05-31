package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class FindLargestNodeWithoutRecursion {
    /***
     * Gives the maximum node by using Level order traversal.Instead of printing the value compare it with the maxValue.
     *
     * @param node
     * @return maximum value
     */
    private Integer findLargestNodeUsingRecursion(BinaryTreeNode node) {
        Integer maxValue = Integer.MIN_VALUE;
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();

            if (current.getData() > maxValue) maxValue = current.getData();

            if (null != current.getLeft()) queue.offer(current.getLeft());
            if (null != current.getRight()) queue.offer(current.getRight());
        }

        return maxValue;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(10, null, null);
        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, null, null);
        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);

        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);

        Integer result = new FindLargestNodeWithoutRecursion().findLargestNodeUsingRecursion(root);

        System.out.println(result);
    }
}
