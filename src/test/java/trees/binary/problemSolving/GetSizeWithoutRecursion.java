package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;

public class GetSizeWithoutRecursion {

    public Integer getSizeWithoutRecursion(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        Integer size = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();

            // System.out.println(current.getData()); Instead of print increment size.
            size++;

            if (null != current.getLeft()) queue.offer(current.getLeft());
            if (null != current.getRight()) queue.offer(current.getRight());
        }

        return size;
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

        Integer result = new GetSizeWithoutRecursion().getSizeWithoutRecursion(root);

        System.out.println(result);
    }
}
