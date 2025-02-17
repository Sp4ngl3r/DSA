package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {

        int currentSum = 0, result = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int i : nums) {

            currentSum += i;
            int differenceElemet = currentSum - k;

            if (prefixSum.containsKey(differenceElemet)) {
                result += prefixSum.get(differenceElemet);
            }

            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}
// @lc code=end
