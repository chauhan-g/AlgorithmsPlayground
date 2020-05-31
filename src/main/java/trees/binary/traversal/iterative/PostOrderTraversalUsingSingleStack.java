package trees.binary.traversal.iterative;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

public class PostOrderTraversalUsingSingleStack {

    /***
     * Prints the BinaryTreeNode of the Binary tree in post Order.
     *
     * Problem with root in postorder traversal is that it is visited three times, moving down from parent, coming up from left child and coming up from right child. When should be the node processed? Well, when we are coming up from right child.
     * How can we keep track of how the current node was reached? If we keep previous pointer, there are three cases:
     * - Previous node is parent of current node, we reached node from parent node, nothing is done.
     * - Previous node is left child of current node, it means we have visited left child, but still not visited right child, move to right child of current node.
     * - Previous node is right child of current node, it means  we have visited left and right child of current node,  process the current node.
     *
     * @param root root of the binary tree
     */
    public void postOrderTraversal(BinaryTreeNode root) {
        BinaryTreeNode prev = null;
        Stack<BinaryTreeNode> s = new Stack<>();

        s.push(root);

        while (!s.empty()) {
            BinaryTreeNode current = s.peek(); //Important: Peeking here not poping
            if (prev == null || (prev.getLeft() == current || prev.getRight() == current)) { // We are going down in tree
                if (current.getLeft() != null)
                    s.push(current.getLeft()); // Left subtree first,if it doesnt exists then right subtree
                else if (current.getRight() != null) s.push(current.getRight());
            } else if (prev == current.getLeft()) { //moving up from left subtree
                if (current.getRight() != null) s.push(current.getRight());
            } else { //moving up from right subtree or reached leftmost leaf
                current = s.pop();
                System.out.println(current.getData());
            }

            prev = current;
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

        new PostOrderTraversalUsingSingleStack().postOrderTraversal(root);
    }
}
