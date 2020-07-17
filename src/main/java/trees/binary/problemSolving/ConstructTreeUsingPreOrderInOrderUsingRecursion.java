package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

//TODO(LATER)
public class ConstructTreeUsingPreOrderInOrderUsingRecursion {
    //TODO: Complete below
    private BinaryTreeNode createTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        return null;
    }

    //TODO (New Class): ConstructTreeUsingPreOrderInOrder Without Using Recursion.

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

        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};

        BinaryTreeNode isMirror = new ConstructTreeUsingPreOrderInOrderUsingRecursion().createTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        System.out.println(isMirror);
    }
}
