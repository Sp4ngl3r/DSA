package strings;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {

    public String longestPalindrome(String s) {
        /// Dynamic Progamming Approach
        if (s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddPalindromeLength = expandingFromMiddle(s, i, i);
            int evenPalindromeLength = expandingFromMiddle(s, i, i + 1);
            int maxLength = Math.max(oddPalindromeLength, evenPalindromeLength);

            if (maxLength > end - start) {
                start = i - ((maxLength - 1) / 2);
                end = i + ((maxLength) / 2);
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandingFromMiddle(String s, int left, int right) {
        if (s == null) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
// @lc code=end
