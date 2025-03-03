package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> dictionaryMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            dictionaryMap.put(c, dictionaryMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            // if the character is not present in the dictionary or the count of the character
            // is 0, then return false
            if (dictionaryMap.containsKey(c) && dictionaryMap.get(c) > 0) {
                dictionaryMap.put(c, dictionaryMap.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
