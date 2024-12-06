package strings;

/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }

        // Two Pointer approach
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left <= right) {

            char currentLeftCharacter = s.charAt(left);
            char currentRightCharacter = s.charAt(right);

            // If the character is not letter or digit, ignore it
            if (!Character.isLetterOrDigit(currentLeftCharacter)) {
                left++;
            } else if (!Character.isLetterOrDigit(currentRightCharacter)) {
                right--;
            } else {

                if (currentLeftCharacter != currentRightCharacter) {
                    return false;
                }

                left++;
                right--;
            }

        }

        return true;
    }
}
// @lc code=end
