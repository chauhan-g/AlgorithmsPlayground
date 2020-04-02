package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfLeavesWithoutUsingRecursion {

    private Integer noOfLeavesUsingRecursion(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer leaves = 0;

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            if (null == current.getLeft() && null == current.getRight()) leaves++;

            if (null != current.getLeft()) queue.offer(current.getLeft());
            if (null != current.getRight()) queue.offer(current.getRight());
        }

        return leaves;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, null, null);
        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, null, null);
        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);

        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);

        Integer result = new NoOfLeavesWithoutUsingRecursion().noOfLeavesUsingRecursion(root);

        System.out.println(result);
    }
}
