package algorithms.solution1351;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int count = 0;
        int stopPos = width;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < stopPos; j++) {
                if (grid[i][j] < 0) {
                    count += (stopPos - j) * (height - i);
                    stopPos = j;
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int result = new Solution().countNegatives(grid);
        System.out.println(result);
    }
}
