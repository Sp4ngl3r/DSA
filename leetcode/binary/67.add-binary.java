package binary;

/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {

        StringBuilder resultString = new StringBuilder();
        int carry = 0;

        // initialize two pointers from the end of the strings
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                // subtract '0' to convert char to int
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            // if sum is 2 or 3, carry is 1
            // if sum is 0 or 1, carry is 0
            carry = sum > 1 ? 1 : 0;

            // if sum is 2 or 0, append 0
            // if sum is 3 or 1, append 1
            resultString.append(sum % 2);
        }

        // if carry is 1, append 1
        if (carry != 0) {
            resultString.append(carry);
        }

        return resultString.reverse().toString();
    }
}
// @lc code=end
