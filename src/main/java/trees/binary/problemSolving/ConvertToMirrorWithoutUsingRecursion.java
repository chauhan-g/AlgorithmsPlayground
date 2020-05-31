package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;
import trees.binary.traversal.iterative.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertToMirrorWithoutUsingRecursion {

    private BinaryTreeNode convertToMirrorUsingRecursion(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();

            BinaryTreeNode temp = current.getLeft();
            current.setLeft(current.getRight());
            current.setRight(temp);

            if (null != current.getLeft()) queue.offer(current.getLeft());
            if (null != current.getRight()) queue.offer(current.getRight());
        }

        return root;
    }

    public static void main(String[] args) {
//        /***
//         *          1
//         *         / \
//         *        2   3
//         *       / \   \
//         *      4   5   7
//         *     /   /
//         *    8   10
//         *   /   /
//         *  9   11
//         *
//         */
//        BinaryTreeNode root = new BinaryTreeNode(1);
//        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
//        BinaryTreeNode rootRight = new BinaryTreeNode(3);
//        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, new BinaryTreeNode(8, new BinaryTreeNode(9), null), null);
//        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, new BinaryTreeNode(10, new BinaryTreeNode(11), null), null);
////        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
//        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);
//
//        root.setLeft(rootLeft);
//        root.setRight(rootRight);
//
//        rootLeft.setLeft(rootLeftLeft);
//        rootLeft.setRight(rootLeftRight);
////
////        rootRight.setLeft(rootRightLeft);
//        rootRight.setRight(rootRightRight);

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

        BinaryTreeNode mirror = new ConvertToMirrorWithoutUsingRecursion().convertToMirrorUsingRecursion(root);

        new LevelOrderTraversal().levelOrderTraversal(mirror);
    }
}
