package nowcoder.targetSum;

import algorithms.utils.ListPrinter;

import java.util.HashMap;

/**
 * @author 肖皓星
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[0];
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }

        }
        return new int[0];
    }

    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            if (map.containsKey(another) && map.get(another) != i + 1) {
                return new int[]{i + 1, map.get(another)};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 4};
        int target = 6;
        Solution test = new Solution();
        int[] result = test.twoSum2(data, target);
        ListPrinter.printArray(result);
    }
}

