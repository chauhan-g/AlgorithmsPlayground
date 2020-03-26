package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;

public class SearchAnElementWithoutRecursion {

    private BinaryTreeNode searchAnElementUsingRecursion(BinaryTreeNode root, int data) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            BinaryTreeNode current = queue.poll();
            if (current.getData() == data) return current;

            if (null != current.getLeft()) queue.offer(current.getLeft());
            if (null != current.getRight()) queue.offer(current.getRight());
        }

        return null;
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

        BinaryTreeNode result = new SearchAnElementWithoutRecursion().searchAnElementUsingRecursion(root, 17);

        if (null == result) System.out.println("not found");
        else System.out.println(result.getData());
    }
}
