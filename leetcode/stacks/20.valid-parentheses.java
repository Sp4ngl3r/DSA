package leetcode.stacks;

import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();

        for(char ch : s.toCharArray()){
            switch(ch){
                case '(' -> bracketStack.push(')');
                case '{' -> bracketStack.push('}');
                case '[' -> bracketStack.push(']');
                default -> {
                    if(bracketStack.isEmpty() || bracketStack.pop() != ch){
                        return false;
                    }
                }
            }
        }
        return bracketStack.isEmpty();
    }
}
// @lc code=end
