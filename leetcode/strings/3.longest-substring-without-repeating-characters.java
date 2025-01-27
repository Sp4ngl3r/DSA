package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0, maxLength = 0;
        Map<Character, Integer> characterMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!characterMap.containsKey(ch) || characterMap.get(ch) < left) {
                maxLength = Math.max(maxLength, (right - left) + 1);
            } else {
                left = characterMap.get(ch) + 1;
            }
            characterMap.put(ch, right);
        }

        return maxLength;
    }
}
// @lc code=end
