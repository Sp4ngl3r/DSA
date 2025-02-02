package trees;

/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    public TreeNode invertTree(TreeNode root) {

        /// Base case
        if (root == null) {
            return null;
        }

        /// Using DFS method to invert the binary tree,
        /// Swap the left and right child of the root
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        /// Recursively invert the left and right child
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
// @lc code=end
