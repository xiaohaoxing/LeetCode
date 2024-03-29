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

    /**
     * 贪心+二分
     * 核心问题是：为什么新扫到的数字替换掉结果中指定位置的最小数字？
     * 答案：因为扫描是从前向后，因此遇到新的合法数字后，现有长度不会丢失，只是替换掉中途的数了，当新的序列长度超过当前的结果时才会增加 len，使结果更新。
     * 举例：2, 5, 6, 3, 7 这几个数字，先得到 2,5,6这几个序列，再遇到 3，将 5 替换成 3，然后继续到 7，在 6 后面追加 7.得到最终结果长度：4。
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1, right = len + 1, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (d[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                d[left] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 2, 3,};
//        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};
        int[] nums = new int[]{10, 9, 2, 5, 6, 3, 7, 101, 102};
        Solution test = new Solution();
        int result = test.lengthOfLIS2(nums);
        System.out.println(result);
    }
}
