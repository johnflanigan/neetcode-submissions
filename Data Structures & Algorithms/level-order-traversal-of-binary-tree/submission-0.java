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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            Deque<TreeNode> next = new LinkedList<>();
            List<Integer> level = new ArrayList<>();

            while (!deque.isEmpty()) {
                TreeNode node = deque.removeFirst();
                level.add(node.val);

                if (node.left != null) {
                    next.addLast(node.left);
                }
                if (node.right != null) {
                    next.addLast(node.right);
                }
            }

            result.add(level);
            deque = next;
        }

        return result;
    }
}
