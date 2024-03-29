package algorithms.solution97;


/**
 * 有点难的 DP，其实需要 2 个方向一起尝试做或运算。因此循环内有 2 个 if，并与原结果做或运算，类似于求 max。
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i] = new boolean[s2.length() + 1];
        }
        // 初始化
        dp[0][0] = true;
        // dp
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Solution test = new Solution();
        boolean result = test.isInterleave(s1, s2, s3);
        System.out.println(result);
    }
}
