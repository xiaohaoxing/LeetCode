package nowcoder.smallestN;

import algorithms.utils.ListPrinter;

import java.util.ArrayList;

/**
 * @author 肖皓星
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            insert(result, input[i]);
        }
        int max = result.get(result.size() - 1);
        for (int i = k; i < input.length; i++) {
            if (input[i] < max) {
                insertFixedLength(result, input[i]);
                max = result.get(k - 1);
            }
        }
        return result;
    }

    public void insert(ArrayList<Integer> list, int value) {
        boolean inserted = false;

        for (int i = 0; i < list.size() - 1; i++) {
            if (value < list.get(i)) {
                list.add(list.get(list.size() - 1));
                for (int j = list.size() - 1; j > i; j--) {
                    list.set(j, list.get(j - 1));
                }
                list.set(i, value);
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            list.add(value);
        }
    }

    public void insertFixedLength(ArrayList<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (value < list.get(i)) {
                for (int j = list.size() - 1; j > i; j--) {
                    list.set(j, list.get(j - 1));
                }
                list.set(i, value);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] data = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = test.GetLeastNumbers_Solution(data, 4);
        ListPrinter.printList(result);
    }
}
