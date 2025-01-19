package strings;

/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        int temp = x, reverse = 0;

        while (x > 0) {
            int digit = x % 10;
            reverse = (reverse * 10) + digit;
            x /= 10;
        }

        return reverse == temp;
    }
}
// @lc code=end
