package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

/***
 * The diameter of tree is maximum of one of the following:
 *
 *  the diameter of T’s left subtree
 *  the diameter of T’s right subtree
 *  the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
 *
 * Here,we are calculating the height in the same recursion rather than calling a height() separately
 */
public class DiameterUsingHeightInsideDiameterFunction {

    // Using this class so that height (object) could be passed and its value could then be calculated.
    private static class Height {
        Integer value = 0;
    }

    private Integer getDiameter(BinaryTreeNode node, Height height) {

        if (null == node) {
            height.value = 0;
            return 0;
        }

        Height leftHeight = new Height(), rightHeight = new Height();
        Integer leftDiameter = getDiameter(node.getLeft(), leftHeight);
        Integer rightDiameter = getDiameter(node.getRight(), rightHeight);

        //current nodes height would be maximum of left and right subtrees height
        height.value = Math.max(leftHeight.value, rightHeight.value) + 1;

        return Math.max(leftHeight.value + rightHeight.value + 1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
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

        Integer diameter = new DiameterUsingHeightInsideDiameterFunction().getDiameter(root, new Height());

        System.out.println(diameter);
    }
}
