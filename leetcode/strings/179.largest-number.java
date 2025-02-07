package strings;

import java.util.Arrays;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {

        if (nums.length == 0) {
            return "";
        }

        /// Convert the numbers into string
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        /// Sort the strings based on maximum values after appending
        Arrays.sort(numbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNumber = new StringBuilder();
        for (String i : numbers) {
            largestNumber.append(i);
        }

        return largestNumber.toString();
    }
}
// @lc code=end
