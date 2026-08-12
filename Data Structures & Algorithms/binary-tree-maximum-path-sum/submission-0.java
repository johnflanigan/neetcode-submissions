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

    record Result(int max, int leftToRight) {}

    public int maxPathSum(TreeNode root) {
        Result result = maxPathSumHelper(root);
        return Math.max(result.max, result.leftToRight);
    }

    public Result maxPathSumHelper(TreeNode root) {
        Result left = null;
        if (root.left != null) {
            left = maxPathSumHelper(root.left);
        }

        Result right = null;
        if (root.right != null) {
            right = maxPathSumHelper(root.right);
        }

        int leftMax = left == null ? 0 : left.max;
        int rightMax = right == null ? 0 : right.max;

        int leftToRight = root.val;
        leftToRight += Math.max(0, leftMax);
        leftToRight += Math.max(0, rightMax);

        if (left != null) {
            leftToRight = Math.max(leftToRight, left.leftToRight);
        }
        if (right != null) {
            leftToRight = Math.max(leftToRight, right.leftToRight);
        }

        int max = Math.max(0, Math.max(leftMax, rightMax));
        max += root.val;

        return new Result(max, leftToRight);
    }
}
