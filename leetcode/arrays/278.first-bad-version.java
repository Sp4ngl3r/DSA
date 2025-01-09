package arrays;
/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        // Using Binary Search Approach
        int left = 1;
        int right = n;

        while (left < right) {
            // This logic is important to avoid overflow
            int mid = left + (right - left) / 2;

            // If mid is bad version then we need to search in left half
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
// @lc code=end
