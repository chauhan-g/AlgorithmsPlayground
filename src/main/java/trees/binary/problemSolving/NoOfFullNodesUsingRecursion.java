package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class NoOfFullNodesUsingRecursion {
    private static Integer fullNodes = 0;

    private void noOfFullNodesUsingRecursion2(BinaryTreeNode root) {
        if (null == root) return;
        if (null != root.getLeft() && null != root.getRight()) fullNodes++;

        if (null != root.getLeft()) noOfFullNodesUsingRecursion2(root.getLeft());
        if (null != root.getRight()) noOfFullNodesUsingRecursion2(root.getRight());
    }

    /***
     * The idea is to traverse the tree in postorder.
     * If the current node is full, we increment result by 1 and add returned values of left and right subtrees.
     *
     * @param root
     * @return number of full nodes;
     */
    private int noOfFullNodesUsingRecursion(BinaryTreeNode root) {
        if (null == root) return 0;

        int numberOfFullNodes = 0;

        if (null != root.getLeft() && null != root.getRight()) numberOfFullNodes++;

        return numberOfFullNodes + noOfFullNodesUsingRecursion(root.getLeft()) + noOfFullNodesUsingRecursion(root.getRight());
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

        new NoOfFullNodesUsingRecursion().noOfFullNodesUsingRecursion2(root);

        System.out.println(fullNodes);

        Integer result = new NoOfFullNodesUsingRecursion().noOfFullNodesUsingRecursion(root);

        System.out.println(result);
    }
}
