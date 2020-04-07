package algorithms.solution1252;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        short[] rows = new short[n];
        short[] cols = new short[m];
        for (int[] pair : indices) {
            rows[pair[0]]++;
            cols[pair[1]]++;
        }
        int result = 0;
        for (short i = 0; i < n; i++) {
            for (short j = 0; j < m; j++) {
                if ((rows[i] + cols[j]) % 2 == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
