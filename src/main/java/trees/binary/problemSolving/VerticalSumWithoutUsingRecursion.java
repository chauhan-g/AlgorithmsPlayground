package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

//TODO(LATER)
public class VerticalSumWithoutUsingRecursion {
    public void getVerticalSum(BinaryTreeNode root) {
        Map<Integer, Integer> verticalHashAndSumMap = new HashMap<>();

        getVerticalSumHelper(root, 0, verticalHashAndSumMap);

        verticalHashAndSumMap.forEach((verticalHash, sum) -> System.out.println("Column:" + verticalHash + " Sum:" + sum));
    }

    /***
     * We can do an inorder traversal and hash the column.
     * We call getVerticalSumHelper(root, 0) which means the root is at column 0.
     * While doing the traversal, hash the column and increase its value by root.getData().
     *
     * @param root
     * @param verticalHash
     * @param verticalHashAndSumMap
     */
    private void getVerticalSumHelper(BinaryTreeNode root, Integer verticalHash, Map<Integer, Integer> verticalHashAndSumMap) {

        if (null == root) return;

        //(Important)
        verticalHashAndSumMap.put(verticalHash, root.getData() + verticalHashAndSumMap.getOrDefault(verticalHash, 0));

        getVerticalSumHelper(root.getLeft(), verticalHash - 1, verticalHashAndSumMap);
        getVerticalSumHelper(root.getRight(), verticalHash + 1, verticalHashAndSumMap);
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

        new VerticalSumWithoutUsingRecursion().getVerticalSum(root);
    }
}
