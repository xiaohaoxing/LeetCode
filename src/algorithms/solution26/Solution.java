package algorithms.solution26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = nums[0];
        int count = 1;
        for (int i : nums) {
            if (i == prev) {
                continue;
            }
            if (i != prev) {
                nums[count] = i;
                prev = i;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] list = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution test = new Solution();
        int result = test.removeDuplicates(list);
        System.out.println("Result: " + result);
        algorithms.utils.ListPrinter.printArray(list);
    }
}
