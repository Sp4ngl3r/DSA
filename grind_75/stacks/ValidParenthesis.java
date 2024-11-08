package grind_75.stacks;

import java.util.Stack;

/// [Valid Parenthesis](https://leetcode.com/problems/valid-parentheses)

class ValidParenthesis {
    public boolean isValid(String s) {

        Stack<Character> bracketStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                /// Check for the opening parenthesis and push its
                /// corresponding closing parenthesis into the stack
                case '(' -> bracketStack.push(')');
                case '{' -> bracketStack.push('}');
                case '[' -> bracketStack.push(']');
                default -> {
                    /// If its closing parenthesis, pop the stack and check whether
                    /// both are same. If the stack is empty or the popped closing
                    /// parenthesis is not matching, then return false.
                    if (bracketStack.isEmpty() || bracketStack.pop() != ch) {
                        return false;
                    }
                }
            }
        }

        /// If all the parenthesis are traversed, and stack is not empty,
        /// then return false.
        return bracketStack.isEmpty();
    }
}