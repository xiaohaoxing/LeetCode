package algorithms.solution70;

public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        int i = 2;
        while (i < n) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 3;
        Solution test = new Solution();
        int result = test.climbStairs(n);
        System.out.println(result);
    }
}
