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

    record Result(boolean foundP, boolean foundQ, TreeNode lca) {}

    private static final Result EMPTY = new Result(false, false, null);

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = helper(root, p, q);
        return result.lca;
    }

    private Result helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return EMPTY;
        }

        Result left = helper(root.left, p, q);
        Result right = helper(root.right, p, q);

        if (left.lca != null) {
            return left;
        }
        if (right.lca != null) {
            return right;
        }

        boolean foundP = left.foundP || right.foundP || root.equals(p);
        boolean foundQ = left.foundQ || right.foundQ || root.equals(q);

        TreeNode lca = null;
        if (foundP && foundQ) {
            lca = root;
        }
        return new Result(foundP, foundQ, lca);
    }
}
