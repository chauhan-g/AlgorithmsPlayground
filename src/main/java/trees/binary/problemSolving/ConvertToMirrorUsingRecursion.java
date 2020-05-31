package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;
import trees.binary.traversal.iterative.LevelOrderTraversal;

public class ConvertToMirrorUsingRecursion {

    private BinaryTreeNode convertToMirrorUsingRecursion(BinaryTreeNode node) {

        if (null != node) {
            BinaryTreeNode temp = node.getLeft();

            convertToMirrorUsingRecursion(node.getLeft());
            convertToMirrorUsingRecursion(node.getRight());

            node.setLeft(node.getRight());
            node.setRight(temp);
        }

        return node;

        //Below is my how I implemented first.
/*        if (null == node) return null;

        BinaryTreeNode temp = node.getRight();

        node.setRight(node.getLeft());
        node.setLeft(temp);
        //Calculate sum of both left and right subtrees and add it to current node data.
        convertToMirrorUsingRecursion(node.getLeft());
        convertToMirrorUsingRecursion(node.getRight());

        return node;*/
    }

    public static void main(String[] args) {
        /***
         *          1
         *         / \
         *        2   3
         *       / \   \
         *      4   5   7
         *     /   /
         *    8   10
         *   /   /
         *  9   11
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, new BinaryTreeNode(8, new BinaryTreeNode(9), null), null);
        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, new BinaryTreeNode(10, new BinaryTreeNode(11), null), null);
//        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);
//
//        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);

//        BinaryTreeNode root = new BinaryTreeNode(1);
//        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
//        BinaryTreeNode rootRight = new BinaryTreeNode(3);
//        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, null, null);
//        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, null, null);
//        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
//        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);
//
//        root.setLeft(rootLeft);
//        root.setRight(rootRight);
//
//        rootLeft.setLeft(rootLeftLeft);
//        rootLeft.setRight(rootLeftRight);
//
//        rootRight.setLeft(rootRightLeft);
//        rootRight.setRight(rootRightRight);

        BinaryTreeNode mirror = new ConvertToMirrorUsingRecursion().convertToMirrorUsingRecursion(root);

        new LevelOrderTraversal().levelOrderTraversal(mirror);
    }
}
