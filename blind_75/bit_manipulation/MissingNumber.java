package blind_75.bit_manipulation;

import java.util.Arrays;

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

    
}
