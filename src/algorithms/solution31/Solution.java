package algorithms.solution31;

import algorithms.utils.ListPrinter;
/*
按照大小顺序输出下一个数字：
步骤：
1. 从低位到高位找到第一个 left < right 的位置
2. if 是最低位，则直接交换输出
3. else 把 left 和 右边比自己大一点的数字 swap，再把剩余所有的 sort 了输出
PS：这里"右边比自己大一点的数字：就是最低位的比自己大的数字"
4. if 最后都找不到（这是最大的数字），则直接反转（得到最小的）。
 */

public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                if (i == nums.length - 2) {
                    swap(nums, i);
                    return;
                } else {
                    //swap left和右边所有比自己大的最小的一个
                    int target = i + 1;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] > nums[i]) {
                            target = j;
                        }
                    }
                    swap(nums, i, target);
                    sort(nums, i + 1);
                    return;
                }
            }
        }
        reverse(nums);
    }

    public static int[] swap(int[] nums, int left) {
        int tmp = nums[left];
        nums[left] = nums[left + 1];
        nums[left + 1] = tmp;
        return nums;
    }

    public static int[] swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        return nums;
    }

    public static int[] reverse(int[] nums) {
        int length = nums.length - 1;
        for (int i = 0; i * 2 <= length; i++) {
            swap(nums, i, length - i);
        }
        return nums;
    }

    public static int[] sort(int[] nums, int from) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = from; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i);
                    changed = true;
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] list = new int[]{1, 1, 3, 5};
        Solution test = new Solution();
//        reverse(list);
        for (int i = 0; i < 10; i++) {
            test.nextPermutation(list);
            ListPrinter.printArray(list);
        }
    }
}
