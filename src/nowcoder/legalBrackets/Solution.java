package nowcoder.legalBrackets;

import java.util.Stack;

/**
 * @author 肖皓星
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> expect = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    expect.push(')');
                    break;
                case '[':
                    expect.push(']');
                    break;
                case '{':
                    expect.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (expect.isEmpty()) {
                        return false;
                    }
                    char pre = expect.pop();
                    if (pre != c) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return expect.isEmpty();
    }

    public static void main(String[] args) {
        String in = "{[()]}";
        Solution test = new Solution();
        System.out.println(test.isValid(in));
    }
}
