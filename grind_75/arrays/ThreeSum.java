package grind_75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

///[Three Sum](https://leetcode.com/problems/3sum/description/)
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        /// This problem can be solved by 2 pointers technique used in Two Sum - 2.
        for (int i = 0; i < nums.length - 2; i++) {

            /// To avoid evaluating the adjacent same value in the array.
            if (i == 0 || nums[i] != nums[i - 1]) {

                int low = i + 1, high = nums.length - 1, sum = -nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        /// Move the lower pointer to next same value towards right side of the array.
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        /// Move the higher pointer to next same value towards left side of the array.
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        /// Update the low and high pointers to the adjacent unique values.
                        low++;
                        high--;

                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }
}
