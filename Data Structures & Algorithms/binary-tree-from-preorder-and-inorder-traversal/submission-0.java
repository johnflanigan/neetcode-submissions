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
    
    record Result(TreeNode node, int size) {}
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preorderList = new ArrayList<>();
        for (int i : preorder) {
            preorderList.add(i);
        }
        List<Integer> inorderList = new ArrayList<>();
        for (int i : inorder) {
            inorderList.add(i);
        }

        Result result = buildTreeHelper(preorderList, inorderList);
        return result.node;
    }

    private Result buildTreeHelper(List<Integer> preorder, List<Integer> inorder) {
        if (inorder.size() == 0) {
            return new Result(null, 0);
        } else if (inorder.size() == 1) {
            TreeNode node = new TreeNode(inorder.get(0));
            return new Result(node, 1);
        }

        int rootVal = preorder.get(0);
        int i = inorder.indexOf(rootVal);

        Result left = buildTreeHelper(preorder.subList(1, preorder.size()), inorder.subList(0, i));
        
        Result right = buildTreeHelper(preorder.subList(1 + left.size, preorder.size()), inorder.subList(i + 1, inorder.size()));

        TreeNode root = new TreeNode(rootVal, left.node, right.node);
        int size = 1 + left.size + right.size;
        return new Result(root, size);
    }
}
