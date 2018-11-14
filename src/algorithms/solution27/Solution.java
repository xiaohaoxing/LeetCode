package algorithms.solution27;

/**
 * 要把传入的数组中的给定值全部移除，返回剩余的长度
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int offset = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == val) {
                offset++;
            } else {
                if (offset > 0) {
                    nums[index - offset] = nums[index];
                }
            }
        }
        return nums.length - offset;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        Solution test = new Solution();
        algorithms.utils.ListPrinter.printArray(nums);
        int result = test.removeElement(nums, 2);
        System.out.println("count:" + result);
        algorithms.utils.ListPrinter.printArray(nums);

    }
}
