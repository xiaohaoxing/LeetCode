package algorithms.solution1512;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            if (count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            } else {
                count.put(i, 1);
            }
        }
        int result = 0;
        int[] map = new int[100];
        map[0] = 0;
        map[1] = 0;
        for (int i = 2; i < map.length; i++) {
            map[i] = map[i - 1] + i - 1;
        }
        for (Integer c : count.values()) {
            result += map[c];
        }
        return result;
    }


    public static void main(String[] args) throws AssertionError {
        int[] case1 = new int[]{1, 2, 3, 1, 1, 3};
        int[] case2 = new int[]{1, 1, 1, 1};
        int[] case3 = new int[]{1, 2, 3};
        Solution test = new Solution();
        System.out.println(test.numIdenticalPairs(case1));
        System.out.println(test.numIdenticalPairs(case2));
        System.out.println(test.numIdenticalPairs(case3));
        assert test.numIdenticalPairs(case1) == 4;
        assert test.numIdenticalPairs(case2) == 6;
        assert test.numIdenticalPairs(case3) == 0;
    }
}
