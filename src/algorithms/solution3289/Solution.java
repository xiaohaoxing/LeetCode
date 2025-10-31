package algorithms.solution3289;

import algorithms.utils.ListPrinter;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] marks = new boolean[nums.length];
        int[] result = new int[2];
        int resultCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(marks[nums[i]]) {
                result[resultCount++] = nums[i];
            }
            marks[nums[i]] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        ListPrinter.printArray(test.getSneakyNumbers(new int[]{0,1,1,0}));
        ListPrinter.printArray(test.getSneakyNumbers(new int[]{0,3,2,1,3,2}));
    }
}