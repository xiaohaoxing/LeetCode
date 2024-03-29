package algorithms.solution32;

import algorithms.solution300.Solution;

public class Solution2 {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        if (s.isEmpty()) {
            return 0;
        }
        int max = 0;
        arr[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    arr[i] = i > 1 ? arr[i - 2] + 2 : 2;
                } else if (i - arr[i - 1] > 0 && s.charAt(i - arr[i - 1] - 1) == '(') {
                    arr[i] = (i - arr[i - 1] - 2 >= 0 ? arr[i - arr[i - 1] - 2] : 0) + arr[i - 1] + 2;
                }
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        String t = "(()())";
        Solution2 test = new Solution2();
        int result = test.longestValidParentheses(t);
        System.out.println(result);
    }

}
