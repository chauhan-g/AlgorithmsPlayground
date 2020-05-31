package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

/***
 * The width of tree is maximum number of nodes at any level.
 *
 * We calculate width by :
 * - Calculating the number of level(i,e height) of tree
 * - for each level, pass the root and level to a function to get the number of nodes at that level.
 *      -if root is null , the width is 0, return it.
 *      -if level is 1, the width is 1, return it.
 *      -else recursively call the level and right subtrees by subtracting the current level.
 * - Compare the number of nodes of and return maximum.
 */
public class WidthUsingRecursion {

    private Integer getWidth(BinaryTreeNode root) {
        if (null == root) return 0;
        Integer width = 0;
        Integer levels = getHeight(root);

        for (int level = 1; level <= levels; level++) {
            Integer numberOfNodesAtCurrentLevel = getNumberOfNodes(root, level);

            width = width < numberOfNodesAtCurrentLevel ? numberOfNodesAtCurrentLevel : width;
        }
        return width;
    }

    private Integer getNumberOfNodes(BinaryTreeNode node, int level) {
        if (null == node) return 0;
        if (level == 1) return 1;

        return getNumberOfNodes(node.getLeft(), level - 1) + getNumberOfNodes(node.getRight(), level - 1);
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

        Integer width = new WidthUsingRecursion().getWidth(root);

        System.out.println(width);
    }
}
