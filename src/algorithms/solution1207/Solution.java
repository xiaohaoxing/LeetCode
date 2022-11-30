package algorithms.solution1207;

import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value : count.values()) {
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        Solution test = new Solution();
        boolean result = test.uniqueOccurrences(arr);
        System.out.println(result);
    }
}
