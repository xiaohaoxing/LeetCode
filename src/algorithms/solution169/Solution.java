package algorithms.solution169;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else {
                if (result == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }
}
