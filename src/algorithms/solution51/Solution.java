package algorithms.solution51;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Step> solutions = new ArrayList<>();
        Stack<Step> candidates = new Stack<>();
        for (int i = 0; i < n; i++) {
            Step first = new Step();
            first.pre = null;
            first.row = 0;
            first.col = i;
            first.next = new Step[n];
            candidates.add(first);
        }
        while (!candidates.isEmpty()) {
            Step can = candidates.pop();
            boolean valid = can.isValid();
            if (valid) {
                if (can.row == n - 1) {
                    solutions.add(can);
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    Step current = new Step();
                    can.next[i] = current;
                    current.row = can.row + 1;
                    current.col = i;
                    current.pre = can;
                    current.next = new Step[n];
                    candidates.add(current);
                }
            }
        }
        List<List<String>> results = new ArrayList<>();
        for (Step solution : solutions) {
            Step head = solution;
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {

                    if (j == head.col) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
                head = head.pre;
            }
            results.add(list);
        }
        return results;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        List<List<String>> result = test.solveNQueens(4);
        System.out.println("There are " + result.size() + " results.");
        for (List<String> res : result) {
            for (String str : res) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }

    class Step {
        boolean valid;
        int row;
        int col;

        Step pre;

        Step[] next;

        public boolean isValid() {
            Step current = pre;
            while (current != null && current.row != -1) {
                if (col == current.col || Math.abs(col - current.col) == row - current.row) {
                    valid = false;
                    return false;
                }
                current = current.pre;
            }
            valid = true;
            return true;
        }
    }
}


