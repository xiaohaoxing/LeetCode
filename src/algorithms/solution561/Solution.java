package algorithms.solution561;

import java.util.Arrays;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
