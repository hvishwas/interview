package programming.graph.tree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a
 * tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
class MaxDiameterOfBinaryTree {
    public static void main(String[] args) {
//        TreeNode tree = new TreeNode(1);
//        tree.left = new TreeNode(2);
//        tree.right = new TreeNode(3);
//        tree.left.left = new TreeNode(4);
//        tree.right.left = new TreeNode(5);
//        tree.right.right = new TreeNode(6);
//        tree.right.right.left = new TreeNode(8);
//        tree.right.left.right = new TreeNode(7);
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
//        tree.right = new TreeNode(20);
//        tree.right.left = new TreeNode(15);
//        tree.right.right = new TreeNode(7);
        System.out.println("Max diameter: " + diameterOfBinaryTree(tree));
    }

    private static int diameterOfBinaryTree(TreeNode tree) {

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