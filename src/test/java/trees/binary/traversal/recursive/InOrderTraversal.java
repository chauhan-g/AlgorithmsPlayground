package trees.binary.traversal.recursive;

import trees.binary.BinaryTreeNode;

public class InOrderTraversal {

    private void inOrderTraversal(BinaryTreeNode node) {
        if (null == node) return;

        inOrderTraversal(node.getLeft());

        System.out.println(node.getData());

        inOrderTraversal(node.getRight());
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

        rootRight.setLeft(rootRightLeft);
        rootRight.setRight(rootRightRight);

        new InOrderTraversal().inOrderTraversal(root);

    }
}
