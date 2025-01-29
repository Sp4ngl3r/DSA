package stacks;

import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        String operators = "+-/*";

        for (String token : tokens) {
            if (operators.contains(token)) {
                int operand2 = s.pop();
                int operand1 = s.pop();
                int result = 0;

                if (token.equals("+")) {
                    result = operand1 + operand2;
                } else if (token.equals("-")) {
                    result = operand1 - operand2;
                } else if (token.equals("*")) {
                    result = operand1 * operand2;
                } else {
                    result = operand1 / operand2;
                    if (result < 0) {
                        result = (int) Math.ceil(result);
                    } else {
                        result = (int) Math.floor(result);
                    }
                }
                s.add(result);
            } else {
                s.add(Integer.parseInt(token));
            }
        }

        return s.peek();
    }
}
// @lc code=end
