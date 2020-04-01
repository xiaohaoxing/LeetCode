package algorithms.solution1021;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        char[] chars = S.toCharArray();
        int idx = 0;
        while (idx < chars.length-1) {
            idx = nextClose(chars, idx, result);
            idx++;
        }
        return result.toString();
    }

    public int nextClose(char[] chars, int from, StringBuilder out) {
        int count = 0;
        for (int i = from + 1; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    count++;
                    out.append('(');
                    break;
                case ')':
                    if (count == 0) {
                        return i;
                    } else {
                        count--;
                        out.append(')');
                    }
                    break;
                default:
            }
        }
        return chars.length - 1;
    }

    public static void main(String[] args) {

        String test1 = "(()())(())(()(()))";
        Solution test = new Solution();
        System.out.println(test.removeOuterParentheses(test1));
    }
}
