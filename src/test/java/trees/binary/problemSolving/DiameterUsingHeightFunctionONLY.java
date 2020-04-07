package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

/***
 * This class calculates the diameter of a Binary tree by updating the diameter value inside height function.
 *
 */
public class DiameterUsingHeightFunctionONLY {
    private static Integer diameter = 0;

    private void getDiameter(BinaryTreeNode root) {
        if (null == root) return;

        getHeight(root);
    }

    private Integer getHeight(BinaryTreeNode node) {
        if (null == node) return 0;

        Integer leftHeight = getHeight(node.getLeft());
        Integer rightHeight = getHeight(node.getRight());

        // update the answer, because diameter of a
        // tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        if (leftHeight + rightHeight + 1 > diameter) diameter = leftHeight + rightHeight + 1;

        return Math.max(leftHeight, rightHeight) + 1;
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

        new DiameterUsingHeightFunctionONLY().getDiameter(root);

        System.out.println(diameter);
    }
}
