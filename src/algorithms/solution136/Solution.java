package algorithms.solution136;

import java.util.HashSet;

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> test = new HashSet<>();
        for (int num : nums) {
            if (test.contains(num)) {
                test.remove(num);
            } else {
                test.add(num);
            }
        }
        return test.iterator().next();
    }

    public static void main(String[] args) {
        int[] list = new int[]{4, 1, 2, 1, 2};
        Solution test = new Solution();
        int result = test.singleNumber(list);
        System.out.println(result);
    }
}
