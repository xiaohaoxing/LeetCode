package algorithms.solution599;

import java.util.*;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> l1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            l1.put(list1[i], i);
        }
        List<String> rs = new ArrayList<>();
        int sum = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if (l1.containsKey(list2[i])) {
                int currentSum = l1.get(list2[i]) + i;
                if (currentSum < sum) {
                    rs = new ArrayList<>();
                    rs.add(list2[i]);
                    sum = currentSum;
                } else if (currentSum == sum) {
                    rs.add(list2[i]);
                }
            }
        }
        String[] result = new String[rs.size()];
        return rs.toArray(result);
    }

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution test = new Solution();
        String[] result = test.findRestaurant(list1, list2);
        for (String s : result) {
            System.out.print(s + ",");
        }
    }
}
