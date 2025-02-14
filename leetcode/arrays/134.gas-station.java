package arrays;

/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        /// Greedy Approach

        int totalGas = 0, totalCost = 0;
        for (int i : gas) {
            totalGas += i;
        }
        for (int i : cost) {
            totalCost += i;
        }

        /// We cannot travel if we dont have enough gas.
        if (totalGas < totalCost) {
            return -1;
        }

        int total = 0, result = 0;

        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        return result;
    }
}
// @lc code=end
