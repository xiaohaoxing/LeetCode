package algorithms.solution566;

/**
 * @author 肖皓星
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int fromR = 0;
        int fromC = 0;
        int rSize = nums.length;
        int cSize = nums[0].length;
        if (rSize * cSize != r * c) {
            return nums;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = nums[fromR][fromC];
                fromC++;
                if (fromC == cSize) {
                    fromR++;
                    fromC = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        Solution solution = new Solution();
        int[][] result = solution.matrixReshape(test, r, c);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
