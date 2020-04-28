package algorithms.solution766;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        for (int i = 0; i < x; i++) {
            int current = matrix[i][0];
            for (int j = 1; j < x - i && j < y; j++) {
                if(matrix[i + j][j] != current) {
                    return false;
                }
            }
        }
        for (int j = 0; j < y; j++) {
            int current = matrix[0][j];
            for (int i = 1; i < y - j && i < x; i++) {
                if(matrix[i][j + i] != current) {
                    return false;
                }
            }
        }
        return true;
    }
}
