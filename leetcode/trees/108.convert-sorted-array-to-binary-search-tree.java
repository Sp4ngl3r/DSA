package trees;

/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return bst(0, (nums.length - 1), nums);
    }

    private TreeNode bst(int left, int right, int[] array) {
        if (left > right) {
            return null;
        }

        // find the middle node and create it.
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(array[mid]);

        // create the sub-bst for left and right nodes.
        root.left = bst(left, mid - 1, array);
        root.right = bst(mid + 1, right, array);

        return root;
    }
}
// @lc code=end
