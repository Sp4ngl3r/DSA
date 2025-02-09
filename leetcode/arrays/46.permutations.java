package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {

    private void permutation(int[] nums, List<List<Integer>> result, List<Integer> ds, boolean[] visited) {

        /// During recursion, if we consume all the numbers,
        /// we can add it to the result.
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                /// For every case, we add the number and check
                visited[i] = true;
                ds.add(nums[i]);
                permutation(nums, result, ds, visited);

                /// Now we remove that number and traverse back in the recursion.
                ds.remove(ds.size() - 1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutation(nums, result, ds, visited);
        return result;
    }
}
// @lc code=end
