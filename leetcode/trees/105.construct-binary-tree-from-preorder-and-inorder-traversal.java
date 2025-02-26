package trees;

/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private int point = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeConstructor(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode treeConstructor(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int val = preorder[point++];
        TreeNode root = new TreeNode(val);
        int inorderNode = 0;

        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                inorderNode = i;
            }
        }

        root.left = treeConstructor(preorder, inorder, start, inorderNode - 1);
        root.right = treeConstructor(preorder, inorder, inorderNode + 1, end);

        return root;
    }
}
// @lc code=end
