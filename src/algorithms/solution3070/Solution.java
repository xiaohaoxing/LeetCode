package algorithms.solution3070;

public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        if (grid.length == 0) {
            return 0;
        }
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int count = 0;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                int top = (i == 0) ? 0 : grid[i - 1][j];
                int left = (j == 0) ? 0 : grid[i][j - 1];
                int topLeft = (i == 0 || j == 0) ? 0 : grid[i - 1][j - 1];
                grid[i][j] = top + left - topLeft + grid[i][j];
                if (grid[i][j] <= k) {
                    count += 1;
                } else {
                    maxCol = j;
                    if (j == 0) {
                        maxRow = i;
                    }
                    break;
                }
            }
        }
        return count;
    }

}
