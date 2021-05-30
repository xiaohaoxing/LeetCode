package algorithms.solution46;

import algorithms.utils.ListPrinter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖皓星
 */
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, nums.length - 1);
    }

    public List<List<Integer>> permute(int[] nums, int idx) {
        if (idx == 0) {
            List<List<Integer>> result = new LinkedList<>();
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> pre = permute(nums, idx - 1);
        for (List<Integer> list : pre) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> current = new LinkedList<>(list);
                current.add(i, nums[idx]);
                result.add(current);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution3 test = new Solution3();
        ListPrinter.printList(test.permute(nums));
    }
}
