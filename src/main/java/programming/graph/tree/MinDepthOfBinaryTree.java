package programming.graph.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 2.
 */
class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.left.right = new TreeNode(14);
        tree.left.left = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.left.left = new TreeNode(6);
//        tree.right.right = new TreeNode(7);
        System.out.println("min depth DFS: " + findMinDepthOfBinaryTree_DFS(tree));
        System.out.println("min depth BFS: " + findMinDepthOfBinaryTree_BFS(tree));
    }

    private static int findMinDepthOfBinaryTree_BFS(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>(); // Queue for children nodes
        int level = 1; // Minimum level is 1
        q.add(tree); // Add root to queue

        while (!q.isEmpty()) {
            // Get the amount of items per level. Need to be done in order to keep track of level count
            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }

        return level;
    }

    private static int findMinDepthOfBinaryTree_DFS(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int left = findMinDepthOfBinaryTree_DFS(tree.left);
        int right = findMinDepthOfBinaryTree_DFS(tree.right);
        if (tree.left != null && tree.right == null) {
            return left + 1;
        }
        if (tree.right != null && tree.left == null) {
            return right + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
