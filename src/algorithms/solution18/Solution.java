package algorithms.solution18;

import java.util.*;
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
        Set<List<Integer>> resultSet = new HashSet<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
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
                        List<Integer> one = Arrays.asList(nums[sum1.index1], nums[sum1.index2], nums[sum2.index1], nums[sum2.index2]);
                        one = one.stream().sorted().collect(Collectors.toList());
                        resultSet.add(one);
                    }
                }
            }
        }
        return resultSet.stream().toList();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        int[] arr = new int[]{-5, 5, 4, -3, 0, 0, 4, -2};
//        int[] arr = new int[]{2, 2, 2, 2, 2};
        int[] arr = new int[]{-497, -494, -484, -477, -453, -453, -444, -442, -428, -420, -401, -393, -392, -381, -357, -357, -327, -323, -306, -285, -284, -263, -262, -254, -243, -234, -208, -170, -166, -162, -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, -65, -6, 1, 3, 4, 11, 69, 77, 78, 107, 108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 170, 175, 179, 211, 230, 251, 255, 266, 288, 306, 308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 356, 357, 360, 361, 361, 367, 375, 378, 387, 387, 408, 414, 421, 435, 439, 440, 441, 470, 492};
        List<List<Integer>> result = test.fourSum(arr, 8);
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
