package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * The Level Having Maximum Sum Without Using Recursion of tree is similar to {@link WidthWithoutUsingRecursion}.
 * But instead of calculating number of nodes a level, we calculate the sum of nodes.
 */
public class LevelHavingMaximumSumWithoutUsingRecursion {

    private Integer getLevelHavingMaximumSum(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer level = 0;
        Integer levelWithMaximumSum = 0;
        Integer maxLevelSum = 0;

        while (!queue.isEmpty()) {
            level++;
            Integer size = queue.size();
            Integer levelSum = 0;

            while (size-- > 0) {
                BinaryTreeNode current = queue.poll();

                levelSum += current.getData();

                if (null != current.getLeft()) queue.offer(current.getLeft());
                if (null != current.getRight()) queue.offer(current.getRight());
            }

            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                levelWithMaximumSum = level;
            }
        }

        System.out.println("level " + levelWithMaximumSum + " has maximum sum of : " + maxLevelSum);
        return levelWithMaximumSum;
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

        Integer width = new LevelHavingMaximumSumWithoutUsingRecursion().getLevelHavingMaximumSum(root);

        System.out.println(width);
    }
}
