package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.Stack;

public class HeightOrMaximumDepthUsingStack {

    /***
     * In recursion we are doing postorder traversal.So,in itererative mode,
     * we will again do the postorder traversal using stack and keep checking the size of stack.
     *
     * @param current the root of the node.
     * @return the height or the maximum depth of binary tree.
     */
    public Integer getHeightUsingStack(BinaryTreeNode current) {
        BinaryTreeNode previous = null;
        Stack<BinaryTreeNode> preOrderStack = new Stack<>();
        preOrderStack.push(current);
        Integer height = 0;
        while (!preOrderStack.isEmpty()) {
            current = preOrderStack.peek();
            if (null == previous || ((current == previous.getLeft() || current == previous.getRight()))) {
                if (null != current.getLeft()) preOrderStack.push(current.getLeft());
                else if (null != current.getRight()) preOrderStack.push(current.getRight());
            } else if (current.getLeft() == previous) {
                if (null != current.getRight()) preOrderStack.push(current.getRight());
            } else {
                current = preOrderStack.pop();
                // System.out.println(current.getData());

            }
            previous = current;

            if (preOrderStack.size() > height) height = preOrderStack.size();
        }
        return height;
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

        rootLeftLeft.setLeft(new BinaryTreeNode(8, new BinaryTreeNode(9), null));

        Integer result = new HeightOrMaximumDepthUsingStack().getHeightUsingStack(root);

        System.out.println(result);
    }
}
