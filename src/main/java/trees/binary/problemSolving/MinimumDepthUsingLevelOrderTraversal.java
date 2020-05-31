package trees.binary.problemSolving;

import trees.binary.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthUsingLevelOrderTraversal {

    public Integer getMinimumDepthUsingRecursion(BinaryTreeNode node) {
        Integer minimumDepth = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            minimumDepth++;
            int size = queue.size();
            while (size-- > 0) {
                node = queue.poll();
                if (null == node.getLeft() && null == node.getRight()) return minimumDepth;
                if (null != node.getLeft()) queue.offer(node.getLeft());
                if (null != node.getRight()) queue.offer(node.getRight());
            }
        }
        return minimumDepth;
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

        Integer result = new MinimumDepthUsingLevelOrderTraversal().getMinimumDepthUsingRecursion(root);

        System.out.println(result);
    }
}
