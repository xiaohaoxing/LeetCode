package algorithms.solution18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 看起来是递归+回溯
 */
public class Solution3 {
    Set<List<Integer>> results = new HashSet();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        remainSum(nums, target, 0, 4, new Integer[4]);
        return List.copyOf(this.results);
    }

    public void remainSum(int[] nums, int target, int fromIdx, int remainCount, Integer[] previous) {
        if(remainCount == 0) {
            return;
        }
        for (int i = fromIdx; i < nums.length; i++) {
            if(remainCount == 4 && fromIdx > 0 &&  nums[fromIdx] == nums[fromIdx - 1]) {
                continue;
            }
            System.out.println(String.format("try to calculate %d from %d with count %d", target, fromIdx, remainCount));
            if (nums[i] == target && remainCount == 1) {
                System.out.println("I got an answer!");
                previous[4 - remainCount] = nums[i];
                // 注意：Arrays.asList 是基于数组视图的，如果直接传 previous，
                // 之后对 previous 的修改会反映到已加入的结果中，导致结果数字错误。
                // 这里必须拷贝一份快照再加入结果集。
                Integer[] snapshot = Arrays.copyOf(previous, previous.length);
                Arrays.sort(snapshot);
                results.add(Arrays.asList(snapshot));
            } else {
                previous[4 - remainCount] = nums[i];
                remainSum(nums, target - nums[i], i + 1, remainCount - 1, previous);
            }
        }
    }

    public static void main(String[] args) {
        Solution3 test = new Solution3();
        List<List<Integer>> result = test.fourSum(new int[]{1, 0, -1, 0 ,2, -2}, 0);
        // List<List<Integer>> result = test.fourSum(new int[]{2,2,2,2,2}, 8);
        for(List<Integer> list: result) {
            for(Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

    }

}
