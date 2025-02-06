package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || s.length() < p.length()) {
            return result;
        }

        /// Build character map for p string
        int[] charCounts = new int[26];
        for (char ch : p.toCharArray()) {
            charCounts[ch - 'a']++;
        }

        int left = 0, right = 0, count = p.length();

        /// If we are including a character which is part of the target string
        /// into the sliding window, we decrement its counter in map by 1.
        /// If we are excluding that character and moving our sliding
        /// window, we increment its counter in map by 1.
        while (right < s.length()) {

            char leftCharacter = s.charAt(left);
            char rightCharacter = s.charAt(right);

            /// Check if the right character exists in character map
            if (charCounts[rightCharacter - 'a'] >= 1) {
                count--; // decrease the count
            }

            /// Move the right pointer and decrement its count from character map
            right++;
            charCounts[rightCharacter - 'a']--;

            /// If count is 0, this means we obtained an anagram.
            if (count == 0) {
                result.add(left);
            }

            /// If the sliding window is equal to the length of the target string
            /// move the left pointer.
            if (right - left == p.length()) {

                /// For each valid shifting of the sliding window, increase the counter.
                if (charCounts[leftCharacter - 'a'] >= 0) {
                    count++;
                }
                /// Since we are shifting the slinding window, we are incrementing
                /// the left pointer and increasing its count in map by 1.
                left++;
                charCounts[leftCharacter - 'a']++;
            }
        }

        return result;
    }
}
// @lc code=end
