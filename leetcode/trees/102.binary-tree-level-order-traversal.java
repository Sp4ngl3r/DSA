package trees;

import java.util.*;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        /// This queue holds the value of each node,
        /// at each level at a time.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            /// This holds all the value in the current level
            List<Integer> level = new ArrayList<>();
            int levelCount = q.size();

            for (int i = 0; i < levelCount; i++) {
                /// Pop the first inserted node.
                TreeNode node = q.poll();
                level.add(node.val);

                /// Add the respective childern nodes
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            /// store the set of values in the current level
            result.add(level);
        }

        return result;
    }
}
// @lc code=end
