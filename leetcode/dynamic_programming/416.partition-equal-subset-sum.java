package dynamic_programming;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {

    public boolean canPartition(int[] arr) {
        // Calculate the total sum of the array elements
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equal subsets
        if (totalSum % 2 == 1){
            return false;
        }

        // Calculate the target sum for each subset
        int k = totalSum / 2;
        // Create two arrays to store the DP results for the previous and current rows
        boolean prev[] = new boolean[k + 1];

        // Initialize the first row of the DP table
        prev[0] = true;

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < arr.length; ind++) {
            boolean cur[] = new boolean[k + 1];
            cur[0] = true;
            for (int target = 1; target <= k; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = prev[target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // Update the DP table for the current element and target sum
                cur[target] = notTaken || taken;
            }
            // Update the previous row with the current row for the next iteration
            prev = cur;
        }

        // The result is stored in the last cell of the DP table
        return prev[k];
    }
}
// @lc code=end
