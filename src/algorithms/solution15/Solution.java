package algorithms.solution15;

import java.util.*;

/**
 * 有序数组双指针做，首尾向中间收拢
 * @author haoxingxiao
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        boolean hasZeros = false;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i += 1;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] == 0 && nums[left] == 0 && nums[right] == 0 && !hasZeros) {
                    hasZeros = true;
                    result.add(Arrays.asList(0, 0, 0));
                    break;
                }
                int res = nums[i] + nums[left] + nums[right];
                if (res == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < nums.length - 1 && nums[left + 1] == nums[left]) {
                        left += 1;
                    }
                    while (right > 1 && nums[right - 1] == nums[right]) {
                        right -= 1;
                    }
                    if (nums[i] < 0) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                } else if (res < 0) {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left += 1;
                    }
                    left += 1;
                } else {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right -= 1;
                    }
                    right -= 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] arr = new int[]{1, 1, -2};
//        int[] arr = new int[]{0, 0, 0, 0};
//        int[] arr = new int[]{-2, -3, 0, 0, -2};
        Solution test = new Solution();
        List<List<Integer>> result = test.threeSum(arr);
        for (List<Integer> three : result) {
            for (Integer i : three) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
