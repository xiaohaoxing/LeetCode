package algorithms.solution1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.containsKey(target - nums[i])) {
                return new int[]{list.get(target - nums[i]), i};
            }
            list.put(nums[i], i);
        }
        return null;
    }
}
