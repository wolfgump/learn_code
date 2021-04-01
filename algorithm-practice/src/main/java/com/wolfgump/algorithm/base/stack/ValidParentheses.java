package com.wolfgump.algorithm.base.stack;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * @author ganshitao
 */
@Component
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char element : array) {
            if (element == '(') {
                stack.push(')');
            } else if (element == '{') {
                stack.push('}');
            } else if (element == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != element) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
