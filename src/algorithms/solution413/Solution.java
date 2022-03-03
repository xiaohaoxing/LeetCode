package algorithms.solution413;


/**
 * 一个数组的子等差数列数量（最少 3 个元素）
 * 计算一个 diff 数组，然后利用 diff 数组计算等差数列数量
 * 一个最大等差数组子序列-符合等差数列的通项公式：n * (n - 1) / 2
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] diffs = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diffs[i] = nums[i + 1] - nums[i];
        }
        int diff = diffs[0];
        int count = 1;
        int result = 0;
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] == diff) {
                count++;
            } else {
                if (count > 1) {
                    result += (count * (count - 1) / 2);
                }
                diff = diffs[i];
                count = 1;
            }
        }
        result += (count * (count - 1) / 2);
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 7, 7, 7};
        Solution test = new Solution();
        int result = test.numberOfArithmeticSlices(data);
        System.out.println(result);
    }
}
