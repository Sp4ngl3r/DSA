package blind_75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> differenceMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (differenceMap.containsKey(i)) {
                return new int[]{differenceMap.get(i), i};
            }
            differenceMap.put(target - nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
