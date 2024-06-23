package blind_75.bit_manipulation;

import java.util.Arrays;

///https://leetcode.com/problems/missing-number/description/
public class MissingNumber {


    public int missingNumber(int[] nums) {
        int sum = 0;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            actualSum += i;
        }

        return (actualSum + nums.length) - sum;
    }

    public int missingNumberUsingFunctionalProgramming(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int actualSum = Arrays.stream(nums).sum();

        return sum - actualSum;
    }

    public int missingNumberUsingXOROperator(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = ans ^ i;
        }

        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }
}
