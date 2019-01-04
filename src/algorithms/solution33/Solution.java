package algorithms.solution33;

/*
直接找断点的位置
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // find break point
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                pos = i;
            }
        }
        if (pos == 0) {
            return search(nums, 0, nums.length - 1, target);
        }
        if (target < nums[0]) {
            return search(nums, pos, nums.length - 1, target);
        } else {
            return search(nums, 0, pos - 1, target);
        }

    }

    public static int search(int[] list, int from, int to, int target) {
        // 递归的最终结果：1个元素比值
        if (from == to) {
            return target == list[from] ? from : -1;
        }
        if (target < list[from] || target > list[to]) {
            return -1;
        }
        int middle = (from + to) / 2;
        if (list[middle] < target) {
            return search(list, middle + 1, to, target);
        } else {
            return search(list, from, middle, target);
        }

    }

    public static void main(String[] args) {
        int[] list = new int[]{3, 1};
        int target = 1;
        Solution test = new Solution();
        int result = test.search(list, target);
        System.out.println(result);

    }
}
