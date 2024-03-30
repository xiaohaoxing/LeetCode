package algorithms.solution2962;

import java.util.ArrayList;

/**
 * 超时了！
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                index.add(i);
            }
        }
        if (index.size() < k) {
            return 0;
        }
        long result = 0;
        int[] combinations = new int[nums.length];
        for (int i = 0; i < combinations.length; i++) {
            combinations[i] = i + 1;
        }
        for (int i = 0; i <= index.size() - k; i++) {
            for (int j = i + k - 1; j < index.size(); j++) {
                int leftSize = i == 0 ? index.get(i) : index.get(i) - index.get(i - 1) - 1;
                int rightSize = j == index.size() - 1 ? nums.length - index.get(j) - 1 : index.get(j + 1) - index.get(j) - 1;
                int currentResult = combinations[leftSize] * combinations[rightSize];
                result += currentResult;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 2, 3, 3};
//        int k = 2;
        int[] nums = new int[]{1, 4, 2, 1,};
        int k = 3;
        Solution test = new Solution();
        long result = test.countSubarrays(nums, k);
        System.out.println(result);
    }
}
