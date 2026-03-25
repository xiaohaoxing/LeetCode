package algorithms.solution2906;

import algorithms.utils.ListPrinter;
import algorithms.utils.MatrixPrinter;

public class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long prefix = 1;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (int)prefix;
                prefix = (prefix * grid[i][j]) % 12345;
            }
        }
        long suffix = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                result[i][j] = (int)((suffix * result[i][j]) % 12345);
                suffix = (suffix * grid[i][j]) % 12345;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int[][] case1 = new int[][] { { 1, 2 }, { 3, 4 } };
        int[][] case1 = new int[][]{{12345},{2},{1}};
        Solution test = new Solution();
        int[][] results = test.constructProductMatrix(case1);
        MatrixPrinter.print(results);
    }

}
