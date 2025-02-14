package arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {

        /// Replace the zeroes with -1 in array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int maxLength = 0, sum = 0;
        Map<Integer, Integer> sumUptoIndex = new HashMap<>();

        /// Add a default value, so that if the complete array is contiguous
        /// we provide the starting index to be -1.
        sumUptoIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            /// Take the sum uptil the index.
            sum += nums[i];

            if (sumUptoIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumUptoIndex.get(sum));
            } else {
                sumUptoIndex.put(sum, i);
            }
        }

        return maxLength;
    }
}
// @lc code=end
