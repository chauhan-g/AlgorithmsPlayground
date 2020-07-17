package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.Stack;
import java.util.stream.IntStream;

//TODO(LATER)
public class RootToLeafPathUsingPostOrderTraversal {

    /***
     * Prints the root to leaf path of BinaryTreeNode of the Binary tree using post Order.
     *
     * This approach is similar to {@link trees.binary.traversal.iterative.PostOrderTraversalUsingSingleStack},
     * but the only change is at the time of poping and print the node,we are checking if it is a leaf node.If it is leaf node,then print the stack.
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

                // (<<<IMPORTANT>>>) This is the only change that we are doing, instead of just poping and printing the node in post order traversal,
                // we are checking if it is leaf node, if it is leaf node then we are printing the stack.
                if (null == current.getLeft() && null == current.getRight()) {
                    System.out.println();
                    IntStream.rangeClosed(0, s.size() - 1).forEach(i -> System.out.println(s.get(i).getData()));
                }

                current = s.pop();
            }

            prev = current;
        }
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

        new RootToLeafPathUsingPostOrderTraversal().postOrderTraversal(root);
    }
}
