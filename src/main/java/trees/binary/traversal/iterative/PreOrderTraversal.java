package trees.binary.traversal.iterative;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

public class PreOrderTraversal {

    public void preOrderTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> preOrderStack = new Stack();

        preOrderStack.push(root);

        while (!preOrderStack.isEmpty()) {
            BinaryTreeNode currentNode = preOrderStack.pop();

            System.out.println(currentNode.getData());

            if (null != currentNode.getLeft())
                preOrderStack.push(currentNode.getRight());

            if (null != currentNode.getRight())
                preOrderStack.push(currentNode.getLeft());
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

        new PreOrderTraversal().preOrderTraversal(root);
    }
}
