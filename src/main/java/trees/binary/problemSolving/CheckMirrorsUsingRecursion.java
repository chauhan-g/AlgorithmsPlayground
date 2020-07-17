package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

//TODO(LATER)
public class CheckMirrorsUsingRecursion {

    private Boolean checkMirrorsUsingRecursion(BinaryTreeNode node, BinaryTreeNode node2) {
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

        BinaryTreeNode root2 = new BinaryTreeNode(1);
        BinaryTreeNode root2Left = new BinaryTreeNode(2);
        BinaryTreeNode root2Right = new BinaryTreeNode(3);
        BinaryTreeNode root2LeftLeft = new BinaryTreeNode(10, null, null);
        BinaryTreeNode root2LeftRight = new BinaryTreeNode(5, null, null);
        BinaryTreeNode root2RightLeft = new BinaryTreeNode(6, null, null);
        BinaryTreeNode root2RightRight = new BinaryTreeNode(7, null, null);

        root2.setLeft(root2Left);
        root2.setRight(root2Right);

        root2Left.setLeft(root2LeftLeft);
        root2Left.setRight(root2LeftRight);

        root2Right.setLeft(root2RightLeft);
        root2Right.setRight(root2RightRight);

        Boolean isMirror = new CheckMirrorsUsingRecursion().checkMirrorsUsingRecursion(root, root2);

        System.out.println(isMirror);
    }
}
