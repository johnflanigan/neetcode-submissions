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

    record Result(int depth, boolean isBalanced) {}

    private static final Result EMPTY = new Result(0, true);

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Result result = helper(root);
        return result.isBalanced;
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

        if (!left.isBalanced || !right.isBalanced) {
            return new Result(0, false);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new Result(0, false);
        }

        return new Result(Math.max(left.depth, right.depth) + 1, true);
    }
}
