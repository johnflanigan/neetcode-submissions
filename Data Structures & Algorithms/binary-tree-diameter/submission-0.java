/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private static final Result EMPTY = new Result(0, 0);

    record Result(int depth, int maxDiameter) {}

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Result result = helper(root);

        return Math.max(result.depth, result.maxDiameter) - 1;
    }

    private Result helper(TreeNode node) {
        Result left = EMPTY;
        if (node.left != null) {
            left = helper(node.left);
        }

        Result right = EMPTY;
        if (node.right != null) {
            right = helper(node.right);
        }

        int maxDepth = Math.max(left.depth, right.depth) + 1;

        int maxDiameter = Math.max(left.maxDiameter, right.maxDiameter);
        int through = left.depth + right.depth + 1;

        return new Result(maxDepth, Math.max(maxDiameter, through));
    }
}
