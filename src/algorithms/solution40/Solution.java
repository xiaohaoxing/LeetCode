package algorithms.solution40;

import algorithms.utils.ListPrinter;

import java.util.*;

public class Solution {
    public Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        add(candidates, target, new LinkedList<>(), 0);
        List<List<Integer>> realResult = new LinkedList<>();
        realResult.addAll(result);
        return realResult;
    }

    public void add(int[] candidates, int target, List<Integer> previous, int fromIndex) {
        int currentValue;
        for (int i = fromIndex; i < candidates.length; i++) {
            currentValue = candidates[i];
            if (currentValue == target) {
                List<Integer> current = new LinkedList<>();
                current.addAll(previous);
                current.add(currentValue);
                result.add(current);
            } else if (currentValue < target) {
                List<Integer> current = new LinkedList<>();
                current.addAll(previous);
                current.add(currentValue);
                add(candidates, target - currentValue, current, i + 1);
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution test = new Solution();
        List<List<Integer>> result = test.combinationSum2(input, target);
        ListPrinter.printList(result);
    }
}
