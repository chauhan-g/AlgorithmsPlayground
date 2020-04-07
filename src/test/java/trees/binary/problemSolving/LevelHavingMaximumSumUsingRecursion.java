package trees.binary.problemSolving;

import org.omg.CORBA.INTERNAL;
import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * The Level Having Maximum Sum Using Recursion of tree is similar to {@link WidthUsingRecursion}.
 * But instead of calculating number of nodes a level, we calculate the sum of nodes.
 */
public class LevelHavingMaximumSumUsingRecursion {
    private Integer getLevelHavingMaximumSum(BinaryTreeNode root) {
        Integer levels = getHeight(root);
        Integer levelWithMaximumSum = 0;
        Integer maxLevelSum = 0;

        for (int level = 1; level <= levels; level++) {
            Integer levelSum = getLevelSum(root, level);
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                levelWithMaximumSum = level;
            }
        }

        System.out.println("level " + levelWithMaximumSum + " has maximum sum of : " + maxLevelSum);
        return levelWithMaximumSum;
    }

    private Integer getLevelSum(BinaryTreeNode node, int level) {
        if (null == node) return 0;
        if (level == 1) return node.getData();

        return getLevelSum(node.getLeft(), level - 1) + getLevelSum(node.getRight(), level - 1);
    }

    private Integer getHeight(BinaryTreeNode root) {
        if (null == root) return 0;

        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
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

        Integer width = new LevelHavingMaximumSumUsingRecursion().getLevelHavingMaximumSum(root);

        System.out.println(width);
    }
}
