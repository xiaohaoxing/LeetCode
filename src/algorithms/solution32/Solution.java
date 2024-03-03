package algorithms.solution32;

/**
 * 最长匹配括号对的长度
 * <p>
 * 动态规划最复杂场景：()(()) = () + (())
 * 需要考虑前2个字符+后4个字符之和：
 * 在动态规划到第六个字符时：
 * 是‘)’且上一位DP结果的长度之前的上一位[这里是第三个字符，即第二部分的第一个左括号]是‘（’
 * 表示前面2个部分是可以合并起来计算的。
 * f_6 = f_2 + f5 + 2
 * @author haoxingxiao
 */

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int[] results = new int[s.length()];
        results[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    results[i] = i > 2 ? results[i - 2] + 2 : 2;
                } else if (i - results[i - 1] > 0 && s.charAt(i - results[i - 1] - 1) == '(') {
                    results[i] = (i - results[i - 1] - 2 >= 0 ? results[i - results[i - 1] - 2] : 0) + results[i - 1] + 2;
                }
            }
            max = Math.max(max, results[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        String testcase = "()(()";
//        String testcase = "(()";
        Solution test = new Solution();
        int result = test.longestValidParentheses(testcase);
        System.out.println(result);
    }
}
