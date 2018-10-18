package algorithms.solution18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4sum:
 * 给定一个序列,要求给出所有4个数字组合=target 的组合。
 * 可以考虑2-2组合。就换成了2sum 的组合。
 * 需要手动去重，即使是他输入的重复.
 * <p>
 * 现在的问题就是运行超时。
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        if (target > max * 4 || target < min * 4) {
            return result;
        }
        LinkedList<Kernel> sums = new LinkedList();
        int range = nums.length - 1;
        for (int i = 0; i < range; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sums.add(new Kernel(i, j));
            }
        }

        int sumRange = sums.size() - 1;
        for (int i = 0; i < sumRange; i++) {
            for (int j = i + 1; j < sums.size(); j++) {
                Kernel sum1 = sums.get(i);
                Kernel sum2 = sums.get(j);
                if (sum1.index2 < sum2.index1) {
                    if (nums[sum1.index1] + nums[sum1.index2] + nums[sum2.index1] + nums[sum2.index2] == target) {
                        List<Integer> one = new LinkedList<>(Arrays.asList(nums[sum1.index1], nums[sum1.index2], nums[sum2.index1], nums[sum2.index2]));
                        one = one.stream().sorted().collect(Collectors.toList());
                        if (!result.contains(one)) {
                            result.add(one);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<List<Integer>> result = test.fourSum(new int[]{-5, 5, 4, -3, 0, 0, 4, -2}, 4);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Kernel {
    Kernel(int a, int b) {
        index1 = a;
        index2 = b;
    }

    public int index1;
    public int index2;
}
