package algorithms.solution115;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[t.length()];
        }
        // init
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
        }
        // forward
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    int count = 0;
                    for (int k = 0; k < i; k++) {
                        count += dp[k][j - 1];
                    }
                    dp[i][j] = count;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += dp[i][t.length() - 1];
        }
        return result;
    }

    public static void main(String[] args) {
//        String s = "babgbag";
//        String t = "bag";
        String s = "rabbbit";
        String t = "rabbit";
        Solution test = new Solution();
        int result = test.numDistinct(s, t);
        System.out.println(result);
    }
}
