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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int maxSeen) {
        int count = 0;
        if (root.val >= maxSeen) {
            count++;
        }

        maxSeen = Math.max(maxSeen, root.val);
        if (root.left != null) {
            count += helper(root.left, maxSeen);
        }
        if (root.right != null) {
            count += helper(root.right, maxSeen);
        }

        return count;
    }
}
