package algorithms.solution300;

/**
 * DP 第一题，不要求索引连续，因此每一步需要返回去找所有的前面的最长值去递增。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 2, 3,};
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        Solution test = new Solution();
        int result = test.lengthOfLIS(nums);
        System.out.println(result);
    }
}
