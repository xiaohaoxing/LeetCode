package algorithms.solution39;

import algorithms.utils.ListPrinter;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            } else if (candidates[i] == target) {
                List<Integer> current = new LinkedList<>();
                current.add(candidates[i]);
                result.add(current);
            } else {
                List<Integer> current = new LinkedList<>();
                current.add(candidates[i]);
                add(candidates, target - candidates[i], current, i);
            }
        }
        return result;
    }

    public void add(int[] candidates, int target, List<Integer> previous, int fromIndex) {
        for (int i = fromIndex; i < candidates.length; i++) {
            int currentValue = candidates[i];
            List<Integer> current = new LinkedList<>();
            current.addAll(previous);
            if (currentValue == target) {
                current.add(currentValue);
                result.add(current);
            } else if (currentValue < target) {
                current.add(currentValue);
                add(candidates, target - currentValue, current, i);
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] input = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> result = test.combinationSum(input, target);
        ListPrinter.printList(result);
    }
}
