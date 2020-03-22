package trees.binary.traversal.iterative;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

public class InOrderTraversal {

    private void inOrderTraversal(BinaryTreeNode current) {
        Stack<BinaryTreeNode> s = new Stack<>();

        while (null != current || !s.isEmpty()) {

            while (null != current) {
                s.push(current);
                current = current.getLeft();
            }

            BinaryTreeNode res = s.pop();

            System.out.println(res.getData());

            current = res.getRight();
        }
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
