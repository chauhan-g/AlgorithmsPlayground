package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

//TODO(LATER)
public class NoOfHalfNodesUsingRecursion {

    /***
     * The idea is to traverse the tree in postorder.
     * If the current node is full, we increment result by 1 and add returned values of left and right subtrees.
     *
     * @param root
     * @return number of full nodes;
     */
    private int noOfHalfNodesUsingRecursion(BinaryTreeNode root) {
        return 0;
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

        Integer result = new NoOfHalfNodesUsingRecursion().noOfHalfNodesUsingRecursion(root);

        System.out.println(result);
    }
}
