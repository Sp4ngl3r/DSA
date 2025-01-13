package arrays;

// import java.util.HashMap;
// import java.util.Map;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {

        // Approach 1
        // Map<Integer, Integer> map = new HashMap<>();

        // // Count the frequency of each element
        // for (int num : nums) {
        // map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // // Find the element with frequency greater than n/2
        // for (int num : nums) {
        // if (map.get(num) > nums.length / 2) {
        // return num;
        // }
        // }

        // return -1;

        // Approach 2
        // Boyer-Moore Voting Algorithm
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            // If count is 0, then assign the current element as candidate
            if (count == 0) {
                candidate = num;
            }

            // If the current element is equal to candidate, then increment the count
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
// @lc code=end
