package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterMap = new HashMap<>();

        // Increment counters for all the characters in the first string.
        for (char ch : s.toCharArray()) {
            characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
        }

        // Decrement the above counters for all the characters in the second string.
        for (char ch : t.toCharArray()) {
            characterMap.put(ch, characterMap.getOrDefault(ch, 0) - 1);
        }

        for (int value : characterMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
