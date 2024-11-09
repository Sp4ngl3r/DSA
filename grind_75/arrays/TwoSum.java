package grind_75.arrays;

import java.util.HashMap;
import java.util.Map;

///[Two Sum](https://leetcode.com/problems/two-sum/description/)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (differenceMap.containsKey(i)) {
                return new int[] { differenceMap.get(i), i };
            }
            differenceMap.put(target - nums[i], i);
        }

        return new int[] { -1, -1 };
    }

}
