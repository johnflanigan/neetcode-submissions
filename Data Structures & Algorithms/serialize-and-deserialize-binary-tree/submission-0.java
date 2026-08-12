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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        String result = root.val + "-" + left + "-" + right;
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("-");
        Result result = deserializeHelper(strs, 0);
        return result.node;
    }

    record Result(TreeNode node, int size) {}

    private Result deserializeHelper(String[] strs, int i) {
        if (strs[i].equals("null")) {
            return new Result(null, 1);
        }

        int rootVal = Integer.parseInt(strs[i]);
        Result left = deserializeHelper(strs, i + 1);
        Result right = deserializeHelper(strs, i + 1 + left.size);
        TreeNode root = new TreeNode(rootVal, left.node, right.node);
        return new Result(root, 1 + left.size + right.size);
    }
}
