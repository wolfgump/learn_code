package com.wolfgump.algorithm.leetcode.explore.tiq.others;

import java.util.Stack;

/**
 * @author ShiTao.Gan
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 **/
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s==null){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        char[] array=s.toCharArray();
        for(char element:array){
            if(element=='('){
                stack.push(')');
            }
            else if(element=='{'){
                stack.push('}');
            }
            else if(element=='['){
                stack.push(']');
            }
            else if(stack.isEmpty()||stack.pop()!=element){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
