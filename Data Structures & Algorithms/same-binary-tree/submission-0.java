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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> dequeP = new LinkedList<>();
        Deque<TreeNode> dequeQ = new LinkedList<>();

        dequeP.addLast(p);
        dequeQ.addLast(q);

        while (!dequeP.isEmpty() && !dequeQ.isEmpty()) {
            TreeNode nodeP = dequeP.removeFirst();
            TreeNode nodeQ = dequeQ.removeFirst();

            if (nodeP == null && nodeQ == null) {
                continue;
            } else if (nodeP == null || nodeQ == null) {
                return false;
            }

            if (nodeP.val != nodeQ.val) {
                return false;
            }

            dequeP.addLast(nodeP.left);
            dequeP.addLast(nodeP.right);
            dequeQ.addLast(nodeQ.left);
            dequeQ.addLast(nodeQ.right);
        }

        return dequeP.isEmpty() && dequeQ.isEmpty();
    }
}
