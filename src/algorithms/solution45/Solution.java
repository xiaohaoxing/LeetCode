package algorithms.solution45;

import algorithms.utils.ListPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 */
public class Solution {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        boolean[] stayed = new boolean[nums.length];
        stayed[0] = true;
        for (int i = 1; i < nums.length; i++) {
            stayed[i] = false;
        }
        int times = 0;
        List<Integer> currentIndexes = new ArrayList<>();
        currentIndexes.add(0);
        while (!currentIndexes.contains(target) && !currentIndexes.isEmpty()) {
            List<Integer> nextIndexes = new ArrayList<>();
            for (Integer index : currentIndexes) {
                int range = nums[index];
                int left = Math.max(index - range, 0);
                if (index + range >= target) {
                    return times + 1;
                }
                int right = index + range;
                for (int i = left; i <= right; i++) {
                    if (!stayed[i]) {
                        System.out.println("stayed" + i);
                        nextIndexes.add(i);
                        stayed[i] = true;
                    }
                }
            }
            currentIndexes = nextIndexes;
            times++;
        }
        return times;
    }


    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3};
        Solution test = new Solution();
        int result = test.jump(in);
        System.out.println(result);
    }
}
