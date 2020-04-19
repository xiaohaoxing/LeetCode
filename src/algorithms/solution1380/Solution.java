package algorithms.solution1380;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int minIdx = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    minIdx = j;
                    min = matrix[i][j];
                }
            }
            boolean isLucky = true;
            for (int j = 0; j < matrix.length; j++) {
                if (j != i && matrix[j][minIdx] > min) {
                    isLucky = false;
                }
            }
            if (isLucky) {
                result.add(matrix[i][minIdx]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
//        int[][] test = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] test = new int[][]{{7, 8}, {1, 2}};
        List<Integer> result = new Solution().luckyNumbers(test);
        System.out.println(result);
    }
}
