package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class MinimumDepthUsingRecursion {

    public Integer getMinimumDepthUsingRecursion(BinaryTreeNode node) {
        if (null == node) return 0;

        // using math function :
        // return Math.min(getMinimumDepthUsingRecursion(root.getLeft()), getMinimumDepthUsingRecursion(root.getRight())) + 1;

        //Using normal comparison operator:
        Integer leftSubtreeHeight = getMinimumDepthUsingRecursion(node.getLeft());
        Integer rightSubtreeHeight = getMinimumDepthUsingRecursion(node.getRight());

        return leftSubtreeHeight < rightSubtreeHeight ? leftSubtreeHeight + 1 : rightSubtreeHeight + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
        BinaryTreeNode rootRight = new BinaryTreeNode(3);
        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, null, null);
        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, null, null);
//        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
//        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);

        root.setLeft(rootLeft);
        root.setRight(rootRight);

        rootLeft.setLeft(rootLeftLeft);
        rootLeft.setRight(rootLeftRight);

//        rootRight.setLeft(rootRightLeft);
//        rootRight.setRight(rootRightRight);

        rootLeftLeft.setLeft(new BinaryTreeNode(8, new BinaryTreeNode(9), null));

        Integer result = new MinimumDepthUsingRecursion().getMinimumDepthUsingRecursion(root);

        System.out.println(result);
    }
}
