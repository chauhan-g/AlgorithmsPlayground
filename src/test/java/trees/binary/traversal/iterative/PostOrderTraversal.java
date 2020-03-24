package trees.binary.traversal.iterative;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

public class PostOrderTraversal {

    /***
     * Prints the node of the Binary tree in post Order.
     *
     * The algorithms is similar to pre order traversal with just two changes:
     * 1. Instead of poping and printing the node,push it to another stack.
     * 2. Instead of pushing right subtree first ,push left subtree and then push the right subtree.
     *
     * @param root root of the binary tree
     */
    public void postOrderTraversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> postOrderStack = new Stack();
        Stack<BinaryTreeNode> secondaryStack = new Stack();

        secondaryStack.push(root);

        while (!secondaryStack.isEmpty()) {
            BinaryTreeNode currentNode = secondaryStack.pop();

            postOrderStack.push(currentNode);

            if (null != currentNode.getLeft()) secondaryStack.push(currentNode.getLeft());
            if (null != currentNode.getRight()) secondaryStack.push(currentNode.getRight());
        }

        while (!postOrderStack.isEmpty()) {
            BinaryTreeNode current = postOrderStack.pop();
            System.out.println(current.getData());
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

        new PostOrderTraversal().postOrderTraversal(root);
    }
}
