package trees;

/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int minNodeValue = Math.min(p.val, q.val);
        int maxNodeValue = Math.max(p.val, q.val);

        while (root != null) {

            if (root.val > maxNodeValue) {
                root = root.left;
            } else if (root.val < minNodeValue) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }
}
// @lc code=end
