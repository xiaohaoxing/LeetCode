package algorithms.solution283;

import algorithms.utils.ListPrinter;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int fromIdx = 0;
        int toIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                toIdx += 1;
            } else {
                if (fromIdx != toIdx) {
                    nums[fromIdx] = nums[i];
                    nums[i] = 0;
                }
                fromIdx += 1;
                toIdx += 1;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{0, 1, 0, 3, 12};
        ListPrinter.printArray(test);
        new Solution().moveZeroes(test);
        ListPrinter.printArray(test);
    }
}
