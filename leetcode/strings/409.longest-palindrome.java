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

        Set<Character> characterMap = new HashSet<>();
        int longestPalindromeLength = 0;

        // If a character is already present in the set,
        // then it can be used to form a palindrome.
        for (char c : s.toCharArray()) {
            if (characterMap.contains(c)) {
                characterMap.remove(c);
                longestPalindromeLength += 2;
            } else {
                characterMap.add(c);
            }
        }

        // If there are any characters left in the set,
        // then we can use one of them to form a palindrome.
        if (!characterMap.isEmpty()) {
            longestPalindromeLength++;
        }

        return longestPalindromeLength;
    }
}
// @lc code=end