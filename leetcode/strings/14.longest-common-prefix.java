package strings;

import java.util.Arrays;

/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return prefix.toString();
            }

            prefix.append(first.charAt(i));
        }

        return prefix.toString();
    }
}
// @lc code=end
