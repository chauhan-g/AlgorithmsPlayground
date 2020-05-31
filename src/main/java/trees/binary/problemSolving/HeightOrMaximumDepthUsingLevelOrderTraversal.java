package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HeightOrMaximumDepthUsingLevelOrderTraversal {

    /***
     * In the levelorder traversal we are using queue.
     * The only change from level order traversal is that:
     * we are polling all the nodes of a level instead of polling and printing one by one.
     *
     * @param current the root of the node.
     * @return the height or the maximum depth of binary tree.
     */
    public Integer getHeightUsingLOTraversal(BinaryTreeNode current) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Integer height = 0;
        queue.offer(current);
        while (!queue.isEmpty()) {
            Integer size = queue.size(); // Check the size of the queue (i.e number of current level nodes) and insert all the corresponding nodes of next level.
            height++;
            while (size-- > 0) {
                current = queue.poll();
                if (null != current.getLeft()) queue.offer(current.getLeft());
                if (null != current.getRight()) queue.offer(current.getRight());
            }
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

        Integer result = new HeightOrMaximumDepthUsingLevelOrderTraversal().getHeightUsingLOTraversal(root);

        System.out.println(result);
    }
}
