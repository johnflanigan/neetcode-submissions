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

    record Result(boolean isValid, int min, int max) {}

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Result result = dfs(root);
        return result.isValid;
    }

    private Result dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Result(true, node.val, node.val);
        } else if (node.left == null && node.right != null) {
            Result result = dfs(node.right);
            boolean isValid = result.isValid && node.val < result.min && node.val < result.max;
            return new Result(isValid, node.val, result.max);
        } else if (node.left != null  && node.right == null){
            Result result = dfs(node.left);
            boolean isValid = result.isValid && node.val > result.min && node.val > result.max;
            return new Result(isValid, result.min, node.val);
        } else {
            Result left = dfs(node.left);
            Result right = dfs(node.right);
            boolean isValid = left.isValid && right.isValid && node.val > left.max && node.val < right.min;
            return new Result(isValid, left.min, right.max);
        }
    }
}
