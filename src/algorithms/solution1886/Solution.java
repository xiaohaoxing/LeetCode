package algorithms.solution1886;

public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int t = 0; t <= 3; t++) {
            if (equals(mat, target)) {
                return true;
            }
            mat = rotate(mat);
        }
        return false;
    }

    public int[][] rotate(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // 先对角线翻转再左右镜像翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                // swap
                int tmp = mat[j][i];
                mat[j][i] = mat[i][j];
                mat[i][j] = tmp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = tmp;
            }
        }
        return mat;
    }

    public boolean equals(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{
            {1,1},{0,1}
        };
        int[][] target = new int[][]{
            {1,1},{1,0}
        };
        Solution test = new Solution();
        boolean result = test.findRotation(mat, target);
        System.out.println(result);
    }
}
