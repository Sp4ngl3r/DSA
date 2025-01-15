package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanCharactersMap = new HashMap<>();
        romanCharactersMap.put('I', 1);
        romanCharactersMap.put('V', 5);
        romanCharactersMap.put('X', 10);
        romanCharactersMap.put('L', 50);
        romanCharactersMap.put('C', 100);
        romanCharactersMap.put('D', 500);
        romanCharactersMap.put('M', 1000);

        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanCharactersMap.get(s.charAt(i));

            if (4 * currentValue < result) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
        }

        return result;
    }
}
// @lc code=end
