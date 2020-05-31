package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class FindLargestNodeUsingRecursion {
    /***
     * Gives the maximum node by getting maximum value from left subtree
     * and then right subtree
     * and then comparing the maximum of two with the current node.
     *
     * @param node
     * @return maximum value
     */
    private Integer findLargestNodeUsingRecursion(BinaryTreeNode node) {
        Integer maxValue = Integer.MIN_VALUE;

        if (null != node) {
            Integer maxLeftSubtreeValue = findLargestNodeUsingRecursion(node.getLeft());
            Integer maxRightSubtreeValue = findLargestNodeUsingRecursion(node.getRight());

            if (maxLeftSubtreeValue > maxRightSubtreeValue) maxValue = maxLeftSubtreeValue;
            else maxValue = maxRightSubtreeValue;

            if (node.getData() > maxValue) maxValue = node.getData();
        }
        return maxValue;
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

        Integer result = new FindLargestNodeUsingRecursion().findLargestNodeUsingRecursion(root);

        System.out.println(result);
    }
}
