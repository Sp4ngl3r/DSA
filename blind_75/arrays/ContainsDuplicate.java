package blind_75.arrays;

import java.util.HashSet;
import java.util.Set;

///https://leetcode.com/problems/contains-duplicate/description/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hashSet = new HashSet<>();

        for (int i : nums) {

            if (hashSet.contains(i)) {
                return true;
            }

            hashSet.add(i);
        }

        return false;
    }

}
