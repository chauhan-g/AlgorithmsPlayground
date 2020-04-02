package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class NoOfLeavesUsingRecursion {

    private Integer noOfLeavesUsingRecursion(BinaryTreeNode root) {
        if (null == root) return 0;
        if (null == root.getLeft() && null == root.getRight()) return 1;

        return noOfLeavesUsingRecursion(root.getLeft()) + noOfLeavesUsingRecursion(root.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, null, null);
        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, null, null);
        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);

//        rootRight.setLeft(rootRightLeft);
//        rootRight.setRight(rootRightRight);

        Integer result = new NoOfLeavesUsingRecursion().noOfLeavesUsingRecursion(root);

        System.out.println(result);
    }
}
