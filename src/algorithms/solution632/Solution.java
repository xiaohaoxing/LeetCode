package algorithms.solution632;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int x = A.length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < (x + 1) / 2; j++) {
                int temp = A[i][j];
                A[i][j] = 1 - A[i][x - j - 1];
                A[i][x - j - 1] = 1 - temp;
            }
        }
        return A;
    }
}
