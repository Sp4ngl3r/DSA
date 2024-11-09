package grind_75.arrays;

///[Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description)
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int maximum = Integer.MIN_VALUE;
        int currentMaximum = 1;
        int currentMinimum = 1;

        for (int num : nums) {

            // If negative number is encountered, reverse the minimum and maximum.
            if (num < 0) {
                currentMaximum = currentMaximum + currentMinimum;
                currentMinimum = currentMaximum - currentMinimum;
                currentMaximum = currentMaximum - currentMinimum;
            }

            currentMinimum = Math.min(num, num * currentMinimum);
            currentMaximum = Math.max(num, num * currentMaximum);

            maximum = Math.max(currentMaximum, maximum);
        }

        return maximum;
    }
}
