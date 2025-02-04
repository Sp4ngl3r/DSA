package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {

    private void findCombinations(int index, int[] arr, int target, List<Integer> combination, List<List<Integer>> result){

        /// If we reached the end, check whether we got the target and
        /// add it to the result, else return.
        if(index==arr.length){
            if(target==0){
                result.add(new ArrayList<>(combination));
            }

            return;
        }

        /// Here, in this approach, we either have two options
        /// 1. we can choose the current element
        /// 2. we can discard the current element

        /// First option
        if(arr[index]<=target){
            /// we include the element
            /// reduce the target
            combination.add(arr[index]);
            findCombinations(index, arr, target-arr[index], combination, result);

            /// This is done to remove the latest element if it does not
            /// help in getting the target.
            combination.remove(combination.size()-1);
        }

        /// Second option: to discard the current element
        findCombinations(index+1, arr, target, combination, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
}
// @lc code=end
