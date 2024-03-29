package algorithms.solution1143;

/**
 * 经典问题之：最大公共子序列
 * 直觉告诉我：text1[i] != text2[j] 的时候 dp[i][j] = max(dp[i-1][j], dp[i][j-1])，非常的离谱但是正确的。
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][];
        for (int i = 0; i <= text1.length(); i++) {
            dp[i] = new int[text2.length() + 1];
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "ace";
        String text2 = "abcde";
        Solution test = new Solution();
        int result = test.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

}
