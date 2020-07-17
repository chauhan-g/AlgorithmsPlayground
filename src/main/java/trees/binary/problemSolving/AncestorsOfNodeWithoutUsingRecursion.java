package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

//TODO(LATER)
public class AncestorsOfNodeWithoutUsingRecursion {

    public Boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
        if (null == root) return false;

//      If node is found, the return true
        if (root.getData() == node.getData()) return true;

//      If target is present in either left or right subtree of this node,then print this node
        if (printAllAncestors(root.getLeft(), node) || printAllAncestors(root.getRight(), node)) {
            System.out.println(root.getData());
            return true;
        }

        return false;
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

        new AncestorsOfNodeWithoutUsingRecursion().printAllAncestors(root, new BinaryTreeNode(10));

//        TODO:check the root node case
//        Boolean result = new AncestorsOfNodeUsingRecursion().printAllAncestors(root, root);
//
//        if (!result) System.out.println("Root node or node does not exists");
    }
}
