package trees;
/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public boolean isBalanced(TreeNode root) {
        if (height(root) == -1)
            return false;
        return true;
    }

    // Using DFS method to calculate the height of the tree
    private int height(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }

        // Calculate the height of left and right subtree
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // If any of the subtree is unbalanced, return -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the difference between the height of
        // left and right subtree is greater than 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the tree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
// @lc code=end
