package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

/***
 * (Important)This problem can be solved easily using two stacks. Assume the two stacks are: currentLevel and nextLevel.
 * We would also need a variable to keep track of the current level order (whether it is left to right or right to left).
 * We pop from currentLevel stack and print the node’s value.
 * Whenever the current level order is from left to right, push the node’s left child,
 * then its right child, to stack nextLevel. Since a stack is a Last In First Out (LIFO) structure,
 * the next time that nodes are popped off nextLevel, it will be in the reverse order.
 * On the other hand, when the current level order is from right to left, we would push the node’s right child first, then its left child.
 * Finally, We swap those two stacks at the end of each level (i. e., when currentLevel is empty).
 */
public class ZigZagTreeTraversal {

    public void getLeastCommonAncestor(BinaryTreeNode root) {
        Stack<BinaryTreeNode> currentStack = new Stack<>();
        currentStack.push(root);

        while (!currentStack.isEmpty()) {
            Stack<BinaryTreeNode> nextLevelStack = new Stack<>();
            Boolean leftToRight = true;

            while (!currentStack.isEmpty()) {
                BinaryTreeNode current = currentStack.pop();
                System.out.println(current.getData());

                if (leftToRight) {
                    if (null != current.getLeft()) nextLevelStack.push(current.getLeft());
                    if (null != current.getRight()) nextLevelStack.push(current.getRight());
                } else {
                    if (null != current.getRight()) nextLevelStack.push(current.getRight());
                    if (null != current.getLeft()) nextLevelStack.push(current.getLeft());
                }

                if (currentStack.isEmpty()) {
                    leftToRight = !leftToRight;
                    Stack<BinaryTreeNode> temp = currentStack;
                    currentStack = nextLevelStack;
                    nextLevelStack = temp;
                }

            }
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

        new ZigZagTreeTraversal().getLeastCommonAncestor(root);
    }
}
