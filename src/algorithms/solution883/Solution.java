package algorithms.solution883;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int result = 0;
        // 俯视图 + 正视图
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    result++;
                }
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            result += max;
        }
        // 侧视图
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            result += max;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{3,4}};
        int result =new Solution().projectionArea(grid);
    }
}
