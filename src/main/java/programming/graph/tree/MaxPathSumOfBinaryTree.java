package programming.graph.tree;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at
 * least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 *
 * <p>
 * <img src="../../../../resources/maxPathSumBinaryTree.png">
 * <p>
 */
public class MaxPathSumOfBinaryTree {
    private static int result = 0;

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        findMaxPathSum(root);
        System.out.println(result);
    }

    private static int findMaxPathSum(Node node) {
        if (node == null) {
            return 0;
        }
        int left = findMaxPathSum(node.left);
        int right = findMaxPathSum(node.right);
        int maxChild = Math.max(Math.max(left, right) + node.value, node.value);
        int max = Math.max(maxChild, left + right + node.value);
        result = Math.max(result, max);
        return maxChild;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
