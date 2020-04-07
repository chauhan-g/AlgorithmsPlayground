package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

public class StructurallyIdenticalTreesUsingRecursion {
    private Boolean structurallyIdenticalTreesUsingRecursion(BinaryTreeNode node, BinaryTreeNode node2) {
        if (null == node && null == node2) return true;
        if (null == node || null == node2) return false;

        return structurallyIdenticalTreesUsingRecursion(node.getLeft(), node2.getLeft())
                && structurallyIdenticalTreesUsingRecursion(node.getRight(), node2.getRight());
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

        BinaryTreeNode root2 = new BinaryTreeNode(11);
        BinaryTreeNode root2Left = new BinaryTreeNode(21);
        BinaryTreeNode root2Right = new BinaryTreeNode(31);
        BinaryTreeNode root2LeftLeft = new BinaryTreeNode(41, null, null);
        BinaryTreeNode root2LeftRight = new BinaryTreeNode(51, null, null);
        BinaryTreeNode root2RightLeft = new BinaryTreeNode(61, null, null);
        BinaryTreeNode root2RightRight = new BinaryTreeNode(71, null, null);

        root2.setLeft(root2Left);
        root2.setRight(root2Right);

        root2Left.setLeft(root2LeftLeft);
        root2Left.setRight(root2LeftRight);

        root2Right.setLeft(root2RightLeft);
        root2Right.setRight(root2RightRight);

        Boolean result = new StructurallyIdenticalTreesUsingRecursion().structurallyIdenticalTreesUsingRecursion(root, root2);

        System.out.println(result);
    }
}
