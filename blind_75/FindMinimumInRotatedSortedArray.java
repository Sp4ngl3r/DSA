package blind_75;

///https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int result = nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            ///Check whether the elements inside left pointer and right pointer is in ascending order
            ///Then return the lowest element.
            if (nums[left] < nums[right]) {
                return Math.min(result, nums[left]);
            }

            ///Evaluate the middle element and update the minimum element.
            int mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);

            ///If the middle element value is greater than or equal to the left pointer element,
            ///then change the pointers likewise.
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
