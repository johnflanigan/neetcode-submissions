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

    Integer kth = null;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 0);
        return kth;
    }

    /**
    Returns back the count of this subtree
    */
    private int dfs(TreeNode node, int k, int count) {
        if (node.left != null) {
            count = dfs(node.left, k, count);
        }

        count++;
        if (count == k) {
            kth = node.val;
            return count;
        }

        if (node.right != null) {
            count = dfs(node.right, k, count);
        }

        return count;
    }
}
