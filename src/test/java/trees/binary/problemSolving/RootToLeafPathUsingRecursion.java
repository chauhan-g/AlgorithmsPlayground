package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;

/***
 * The Level Having Maximum Sum Without Using Recursion of tree is similar to {@link WidthWithoutUsingRecursion}.
 * But instead of calculating number of nodes a level, we calculate the sum of nodes.
 */
public class RootToLeafPathUsingRecursion {

    private void rootToLeafPathUsingRecursion(BinaryTreeNode root, LinkedList<Integer> path) {
        if (null == root) return;

        //append this node to the path list.
        path.add(root.getData());

        //if leaf is reached, print the path to this leaf.
        if (null == root.getLeft() && null == root.getRight()) {
            path.forEach(System.out::print);

            System.out.println();
        }

        //Try both left and right subtrees by passing the current path traversed.
        rootToLeafPathUsingRecursion(root.getLeft(), new LinkedList<>(path));
        rootToLeafPathUsingRecursion(root.getRight(), new LinkedList<>(path));
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

        new RootToLeafPathUsingRecursion().rootToLeafPathUsingRecursion(root, new LinkedList<>());
    }
}
