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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return maxDepthHelper(root, 1);
    }

    private int maxDepthHelper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int left = depth;
        if (node.left != null) {
            left = maxDepthHelper(node.left, depth + 1);
        }
        
        int right = depth;
        if (node.right != null) {
            right = maxDepthHelper(node.right, depth + 1);
        }

        return Math.max(left, right);
    }
}
