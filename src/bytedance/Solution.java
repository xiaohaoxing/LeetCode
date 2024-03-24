package bytedance;

import java.sql.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // handle input
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] numsStr = str.split(",");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        // count each number
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i : nums) {
            if (counts.containsKey(i)) {
                counts.put(i, counts.get(i) + 1);
            } else {
                counts.put(i, 1);
            }
        }

        // calculate the results
        ArrayList<ArrayList<Integer>> results = cal(counts);

        // print the results
        for (ArrayList<Integer> result : results) {
            for (Integer i : result) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> cal(HashMap<Integer, Integer> counts) {
        if (counts.size() == 1) {
            int num = counts.keySet().stream().findFirst().get();
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < counts.get(num); i++) {
                result.add(num);
            }
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            results.add(result);
            return results;
        }
        ArrayList<ArrayList<Integer>> finalResults = new ArrayList<>();
        for (Integer num : counts.keySet()) {
            HashMap<Integer, Integer> newCount = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (counts.get(num) == 1) {
                    // don't put this value
                } else {
                    // TODO same value
                }
            }
            ArrayList<ArrayList<Integer>> results = cal(newCount);
            for (ArrayList<Integer> re : results) {
                re.add(num);
            }
            finalResults.addAll(results);
        }
        return finalResults;
    }
}
