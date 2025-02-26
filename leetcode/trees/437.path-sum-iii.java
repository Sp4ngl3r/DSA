package trees;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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

    private Map<Long, Integer> map = new HashMap<>();
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        if (root == null) {
            return;
        }

        prefixSum += root.val;

        if (map.containsKey(prefixSum - targetSum)) {
            count += map.get(prefixSum - targetSum);
        }

        if (targetSum == prefixSum) {
            count++;
        }

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtracking
        map.put(prefixSum, map.get(prefixSum) - 1);
    }
}
// @lc code=end
