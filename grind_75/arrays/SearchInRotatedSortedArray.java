package grind_75.arrays;

///[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            ///Searching in Left Sorted Portion
            if (nums[left] <= nums[mid]) {
                ///If the leftmost element is greater or mid-element is lesser than
                // target, then shift left to mid+1, else shift right to mid-1.
                if (nums[left] > target || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            ///Searching in Right Sorted Portion
            else {
                ///Do the opposite of the above case
                if (nums[right] < target || nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
