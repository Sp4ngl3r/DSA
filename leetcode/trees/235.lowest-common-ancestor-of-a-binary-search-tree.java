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

            // If the root value is greater than the max value,
            // then the LCA will be in the left subtree
            if (root.val > maxNodeValue) {
                root = root.left;
            }

            // If the root value is less than the min value,
            // then the LCA will be in the right subtree
            else if (root.val < minNodeValue) {
                root = root.right;
            }

            // If the root value is between the min and max value,
            // then the root is the LCA
            else {
                return root;
            }
        }

        return null;
    }
}
// @lc code=end
