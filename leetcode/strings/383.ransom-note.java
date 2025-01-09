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
            if (dictionaryMap.containsKey(c)) {
                dictionaryMap.put(c, dictionaryMap.get(c) + 1);
            } else {
                dictionaryMap.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
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
