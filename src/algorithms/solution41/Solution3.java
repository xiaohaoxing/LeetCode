package algorithms.solution41;


public class Solution3 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        Solution3 test = new Solution3();
        int result = test.firstMissingPositive(nums);
        System.out.println(result);
    }
}
