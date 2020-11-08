package algorithms.solution217;

import java.util.Arrays;

/**
 * @author 肖皓星
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
