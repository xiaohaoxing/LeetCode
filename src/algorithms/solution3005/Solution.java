package algorithms.solution3005;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int count = 0;
        int[] counts = new int[101];
        for (int i : nums) {
            counts[i] += 1;
            if (counts[i] > max) {
                count = counts[i];
                max = counts[i];
            } else if (counts[i] == max) {
                count += counts[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] testcase = new int[]{1,2,3,4,5};
        Solution test = new Solution();
        int result = test.maxFrequencyElements(testcase);
        System.out.println(result);
    }
}
