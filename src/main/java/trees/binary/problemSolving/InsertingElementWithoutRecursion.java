package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;
import trees.binary.traversal.iterative.LevelOrderTraversal;

import java.util.LinkedList;

public class InsertingElementWithoutRecursion {


    private BinaryTreeNode insertingElementWithoutRecursion(BinaryTreeNode root, int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        BinaryTreeNode current = root;

        if (null == root) return newNode;

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() || null == current) {

            if (null == current.getLeft()) {
                current.setLeft(newNode);
                return root;
            } else {
                queue.offer(current.getLeft());
            }

            if (null == current.getRight()) {
                current.setRight(newNode);
                return root;
            } else {
                queue.offer(current.getRight());
            }

            current = queue.poll();
        }

        return current;
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

        BinaryTreeNode result = new InsertingElementWithoutRecursion().insertingElementWithoutRecursion(root, 8);

        new LevelOrderTraversal().levelOrderTraversal(result);
    }
}
