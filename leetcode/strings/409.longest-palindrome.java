package strings;

import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {

        Set<Character> characterSet = new HashSet<>();
        int longestPalindromeLength = 0;

        // If a character is already present in the set,
        // then it can be used to form a palindrome.
        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                longestPalindromeLength += 2;
            } else {
                characterSet.add(c);
            }
        }

        // If there are any characters left in the set,
        // then we can use one of them to form a palindrome.
        if (!characterSet.isEmpty()) {
            longestPalindromeLength++;
        }

        return longestPalindromeLength;
    }
}
// @lc code=end
