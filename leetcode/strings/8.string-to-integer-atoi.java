package strings;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {

        int index = 0, answer = 0, sign = +1;

        if (s.isEmpty()) {
            return 0;
        }

        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? +1 : -1;
            index++;
        }

        while (index < s.length()) {
            int digit = s.charAt(index) - '0';

            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < answer
                    || Integer.MAX_VALUE / 10 == answer && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            answer = (answer * 10) + digit;
            index++;
        }

        return answer * sign;
    }
}
// @lc code=end
