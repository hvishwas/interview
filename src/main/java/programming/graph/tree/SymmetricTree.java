package programming.graph.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(2);
        head1.left.left = new TreeNode(3);
        head1.left.right = new TreeNode(4);
        head1.right.left = new TreeNode(4);
        head1.right.right = new TreeNode(3);

        TreeNode head2 = new TreeNode(1);
        head2.left = new TreeNode(2);
        head2.right = new TreeNode(2);
        head2.left.right = new TreeNode(4);
        head2.right.right = new TreeNode(3);

        System.out.println(isSymmetric(head1));
        System.out.println(isSymmetric(head2));
    }

    private static boolean isSymmetric(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
