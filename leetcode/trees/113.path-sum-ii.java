package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPathSum(root, targetSum, result, new ArrayList<Integer>());
        return result;
    }

    private void findPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath) {

        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findPathSum(root.left, targetSum - root.val, result, currentPath);
            findPathSum(root.right, targetSum - root.val, result, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
// @lc code=end
