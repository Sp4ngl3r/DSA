package strings;

/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {

        int[] frequency = new int[26];
        int mostFrequency = 0, left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char leftCharacter = s.charAt(left);
            char rightCharacter = s.charAt(right);

            frequency[rightCharacter - 'A']++;
            mostFrequency = Math.max(mostFrequency, frequency[rightCharacter - 'A']);

            /// The difference between most occuring character and the
            /// length of the sliding window would provide the characters to
            /// be replaced.
            int lettersToChange = (right - left + 1) - mostFrequency;

            /// If we have more letters to be replaced, we need to shift our sliding
            /// window and decrement the count in frequency array.
            if (lettersToChange > k) {
                frequency[leftCharacter - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
// @lc code=end
