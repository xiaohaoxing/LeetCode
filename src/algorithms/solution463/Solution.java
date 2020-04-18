package algorithms.solution463;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    result += calPerimeter(grid, i, j);
                }
            }
        }
        return result;
    }
    
    public int calPerimeter(int[][] grid, int x, int y) {
        int result = 0;
        // top
        if (x == 0 || grid[x - 1][y] == 0) {
            result++;
        }
        // left
        if (y == 0 || grid[x][y - 1] == 0) {
            result++;
        }
        //bottom
        if (x == grid.length - 1 || grid[x + 1][y] == 0) {
            result++;
        }
        // right
        if (y == grid[0].length - 1|| grid[x][y + 1] == 0) {
            result++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] test = new int[1][1];
        test[0][0] = 1;int result = new Solution().islandPerimeter(test);
        
    }
}
