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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root != null) {
            helper(root, 0, result);
        }

        return result;
    }

    private void helper(TreeNode node, int depth, ArrayList<Integer> result) {
        if (depth >= result.size()) {
            result.add(node.val);
        } else {
            result.set(depth, node.val);
        }

        if (node.left != null) {
            helper(node.left, depth + 1, result);
        }
        if (node.right != null) {
            helper(node.right, depth + 1, result);
        }
    }
}
