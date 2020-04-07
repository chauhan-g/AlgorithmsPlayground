package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

/***
 * The diameter of tree is maximum of one of the following:
 *
 *  the diameter of T’s left subtree
 *  the diameter of T’s right subtree
 *  the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
 *
 */
public class DiameterUsingRecursion {

    private Integer getDiameter(BinaryTreeNode node) {
        if (null == node) return 0;

        Integer leftDiameter = getDiameter(node.getLeft());
        Integer rightDiameter = getDiameter(node.getRight());

        Integer leftHeight = getHeight(node.getLeft());
        Integer rightHeight = getHeight(node.getRight());

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    private Integer getHeight(BinaryTreeNode node) {
        if (null == node) return 0;

        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
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

        Integer diameter = new DiameterUsingRecursion().getDiameter(root);

        System.out.println(diameter);
    }
}
