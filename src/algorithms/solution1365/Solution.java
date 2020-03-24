package algorithms.solution1365;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if(i != j && nums[j] < nums[i]) {
                    result[i] ++;
                }
            }
        }
        return result;
    }
}
