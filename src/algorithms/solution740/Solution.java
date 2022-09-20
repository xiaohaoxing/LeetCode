package algorithms.solution740;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return deleteAndEarn(map);
    }

    public int deleteAndEarn(Map<Integer, Integer> counts) {
        int size = counts.size();
        if (size == 1) {
            Map.Entry<Integer, Integer> entry = counts.entrySet().iterator().next();
            return entry.getKey() * entry.getValue();
        }
        int max = 0;
        Object[] nums = counts.keySet().toArray();
        for (int i = 0; i < size; i++) {
            int current = (int) nums[i];
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if ((entry.getKey() == current - 1 || entry.getKey() == current + 1) || (entry.getKey() == current && entry.getValue() == 1)) {
                    continue;
                }
                newMap.put(entry.getKey(), entry.getKey() == current ? entry.getValue() - 1 : entry.getValue());
            }
            System.out.println("new map size is " + newMap.size());
            int result = current + deleteAndEarn(newMap);
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    public int deleteAndEarn2(Map<Integer, Integer> counts) {
        int size = counts.size();
        if (size == 1) {
            Map.Entry<Integer, Integer> entry = counts.entrySet().iterator().next();
            return entry.getKey() * entry.getValue();
        }
        int max = 0;
        Map<Integer, Integer> gains = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int gain = entry.getKey();
            if (counts.containsKey(entry.getKey() - 1)) {
                gain -= (entry.getKey() - 1) * counts.get(entry.getKey() - 1);
            }
            if (counts.containsKey(entry.getKey() + 1)) {
                gain -= (entry.getKey() + 1) * counts.get(entry.getKey() + 1);
            }
            gains.put(entry.getKey(), gain);
        }
        Object[] nums = counts.keySet().toArray();
        for (int i = 0; i < size; i++) {
            int current = (int) nums[i];
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if ((entry.getKey() == current - 1 || entry.getKey() == current + 1) || (entry.getKey() == current && entry.getValue() == 1)) {
                    continue;
                }
                newMap.put(entry.getKey(), entry.getKey() == current ? entry.getValue() - 1 : entry.getValue());
            }
            System.out.println("new map size is " + newMap.size());
            int result = current + deleteAndEarn(newMap);
            if (result > max) {
                max = result;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> case1 = new HashMap<>();
//        case1.put(2, 2);
//        case1.put(3, 3);
//        case1.put(4, 1);
        int[] case1 = new int[]{1, 8, 5, 9, 6, 9, 4, 1, 7, 3, 3, 6, 3, 3, 8, 2, 6, 3, 2, 2, 1, 2, 9, 8, 7, 1, 1, 10, 6, 7, 3, 9, 6, 10, 5, 4, 10, 1, 6, 7, 4, 7, 4, 1, 9, 5, 1, 5, 7, 5};
        Solution test = new Solution();
        int result = test.deleteAndEarn(case1);
        System.out.println(result);
    }
}
