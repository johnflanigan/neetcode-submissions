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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            boolean result = isSubtreeHelper(root, subRoot);
            if (result) {
                return result;
            }
        }

        boolean left = dfs(root.left, subRoot);
        if (left) {
            return left;
        }
        return dfs(root.right, subRoot);
    }

    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (subRoot == null || root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            return isSubtreeHelper(root.left, subRoot.left) && isSubtreeHelper(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
