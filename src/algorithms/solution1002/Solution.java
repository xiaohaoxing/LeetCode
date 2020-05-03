package algorithms.solution1002;

import algorithms.utils.ListPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[][] count = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                count[i][c - 'a'] += 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            int current = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                if (count[j][i] < current) {
                    current = count[j][i];
                }
                
            }
            for (int j = 0; j < current; j++) {
                result.add("" + (char) (i + 'a'));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] test = new String[]{"bella", "label", "roller"};
        List<String> result = new Solution().commonChars(test);
        ListPrinter.printList(result);
    }
}
