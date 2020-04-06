package algorithms.solution557;

import java.util.Stack;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }
            stack.push(c);
        }
        if (!stack.empty()) {
            while (!stack.empty()) {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
}
