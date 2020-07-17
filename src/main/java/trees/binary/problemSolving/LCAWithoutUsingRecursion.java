package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

//TODO(LATER)
public class LCAWithoutUsingRecursion {

    public BinaryTreeNode getLeastCommonAncestor(BinaryTreeNode current, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (null == current) return null;

        // (IMPORTANT) If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        //TODO:Remove this CON-If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
        if (current.getData() == node1.getData() || current.getData() == node2.getData()) return current;

        BinaryTreeNode left = getLeastCommonAncestor(current.getLeft(), node1, node2);
        BinaryTreeNode right = getLeastCommonAncestor(current.getRight(), node1, node2);

        // (IMPORTANT) If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (null != left && null != right) return current;

        // (IMPORTANT Otherwise check if left subtree or right subtree is LCA
        return left != null ? left : right;
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

        BinaryTreeNode LCA = new LCAWithoutUsingRecursion().getLeastCommonAncestor(root, new BinaryTreeNode(10), new BinaryTreeNode(8));

        System.out.println(LCA.getData());
    }
}
