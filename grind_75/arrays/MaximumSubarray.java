package grind_75.arrays;

///[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        ///This uses Kadane's algorithm - Sliding Window Technique
        int currentMaximum = nums[0];
        int overallMaximum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaximum = Math.max(nums[i], currentMaximum + nums[i]);
            overallMaximum = Math.max(overallMaximum, currentMaximum);
        }

        return overallMaximum;
    }

}