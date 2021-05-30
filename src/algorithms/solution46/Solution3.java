package algorithms.solution46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖皓星
 */
public class Solution3 {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, null);
    }


    public List<List<Integer>> permute(int[] nums, int idx, List<List<Integer>> result) {
        if (idx == 0) {
            return permute(nums, 1, Arrays.asList(Arrays.asList(nums[0])));
        }
        if (idx == nums.length) {
            return result;
        }
        List<List<Integer>> newResult = new LinkedList<>();
        for (List<Integer> list : result) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> current = new LinkedList<>(list);
                current.add(i, nums[idx]);
                newResult.add(current);
            }
        }
        return permute(nums, idx + 1, newResult);
    }
}
