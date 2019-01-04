package algorithms.solution35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    public static int searchInsert(int[] nums, int from, int to, int target) {
        if (from == to) {
            if (nums[from] < target) {
                return from + 1;
            } else {
                return from;
            }
        }
        int middle = (from + to) / 2;
        if (nums[middle] < target) {
            return searchInsert(nums, middle + 1, to, target);
        } else {
            return searchInsert(nums, from, middle, target);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 3, 5, 6};
        int target = 0;
        Solution test = new Solution();
        int result = test.searchInsert(list, target);
        System.out.println(result);
    }
}
