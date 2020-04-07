package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * The width of tree is maximum number of nodes at any level.
 *
 * We calculate width by doing level order traversal:
 * The only change from level order traversal is that:
 *      -get the size of the queue because The size of the queue gives the number of nodes at level
 *      -compare it with the width variable.
 *      -poll all the nodes of a level (i.e until the size of queue is not equal to 0) from queue
 *      and offer their corresponding left and right children to queue.(this is unlike polling and printing node one by one in level order traversal).
 *
 */
public class WidthWithoutUsingRecursion {

    private Integer getWidth(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Integer width = 0;

        while (!queue.isEmpty()) {
            Integer size = queue.size();
            width = width < size ? size : width;

            while (size-- > 0) {
                BinaryTreeNode current = queue.poll();

                if (null != current.getLeft()) queue.offer(current.getLeft());
                if (null != current.getRight()) queue.offer(current.getRight());
            }
        }

        return width;
    }

    public static void main(String[] args) {
//        /***
//         *          1
//         *         / \
//         *        2   3
//         *       / \   \
//         *      4   5   7
//         *     /   /
//         *    8   10
//         *   /   /
//         *  9   11
//         *
//         */
//        BinaryTreeNode root = new BinaryTreeNode(1);
//        BinaryTreeNode rootLeft = new BinaryTreeNode(2);
//        BinaryTreeNode rootRight = new BinaryTreeNode(3);
//        BinaryTreeNode rootLeftLeft = new BinaryTreeNode(4, new BinaryTreeNode(8, new BinaryTreeNode(9), null), null);
//        BinaryTreeNode rootLeftRight = new BinaryTreeNode(5, new BinaryTreeNode(10, new BinaryTreeNode(11), null), null);
////        BinaryTreeNode rootRightLeft = new BinaryTreeNode(6, null, null);
//        BinaryTreeNode rootRightRight = new BinaryTreeNode(7, null, null);
//
//        root.setLeft(rootLeft);
//        root.setRight(rootRight);
//
//        rootLeft.setLeft(rootLeftLeft);
//        rootLeft.setRight(rootLeftRight);
////
////        rootRight.setLeft(rootRightLeft);
//        rootRight.setRight(rootRightRight);

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

        Integer width = new WidthWithoutUsingRecursion().getWidth(root);

        System.out.println(width);
    }
}
