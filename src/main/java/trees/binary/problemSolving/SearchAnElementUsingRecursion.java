package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class SearchAnElementUsingRecursion {

    private Boolean searchAnElementUsingRecursion(BinaryTreeNode root, int data) {
        if (null == root) return false;
        if (root.getData() == data) return true;

        return searchAnElementUsingRecursion(root.getLeft(), data) || searchAnElementUsingRecursion(root.getRight(), data);
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

        Boolean result = new SearchAnElementUsingRecursion().searchAnElementUsingRecursion(root, 7);

        System.out.println(result);
    }
}
