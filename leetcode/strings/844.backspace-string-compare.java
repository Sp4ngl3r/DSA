package strings;

/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;
        int backspace1 = 0;
        int backspace2 = 0;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    backspace1++;
                    i--;
                } else if (backspace1 > 0) {
                    backspace1--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(i) == '#') {
                    backspace2++;
                    j--;
                } else if (backspace2 > 0) {
                    backspace2--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && (s.charAt(i) != t.charAt(j))) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
// @lc code=end
