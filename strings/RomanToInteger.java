package strings;

import java.util.HashMap;
import java.util.Map;

///https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {

    public int romanToInt(String s) {

        ///Using switch-case instead of HashMap reduces runtime.
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
