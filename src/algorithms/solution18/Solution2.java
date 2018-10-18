package algorithms.solution18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 试试递归吧
 * 但是递归做去重更不好做啊。。。
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return sum(nums, target, 4, 0);
    }

    public static List<List<Integer>> sum(int[] nums, int target, int count, int from) {
        List<List<Integer>> result = new LinkedList();
        // 终端 count = 1
        if (count == 1) {
            for (int i = from; i < nums.length; i++) {
                if (nums[i] == target) {
                    result.add(new LinkedList<>(Arrays.asList(nums[i])));
                }
            }
            return result;
        }
        for (int i = from; i <= nums.length - count; i++) {
            result.addAll(sum(nums, target - nums[i], count - 1, i + 1));
        }

        // TODO
        return null;

    }
}
