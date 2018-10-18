package algorithms.solution20;

import java.util.Stack;

/**
 * 简单的括号匹配
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    //没有前括号的后括号
                    if (stack.empty()) {
                        return false;
                    }
                    Character before = stack.pop();
                    // not match
                    if (Math.abs(c - before) > 2) {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}