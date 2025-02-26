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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeConstructor(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode treeConstructor(
            int[] preorder,
            int[] inorder,
            int preorderStart,
            int inorderStart,
            int inorderEnd) {

        if (preorderStart > preorder.length - 1 || inorderStart > inorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);
        int currentInorderIndex = 0;

        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == currentInorderIndex) {
                currentInorderIndex = i;
            }
        }

        root.left = treeConstructor(
                preorder,
                inorder,
                preorderStart + 1,
                inorderStart,
                inorderEnd - 1);

        root.right = treeConstructor(
                preorder,
                inorder,
                preorderStart + currentInorderIndex - inorderStart + 1,
                inorderStart,
                inorderEnd);

        return root;
    }
}
// @lc code=end
