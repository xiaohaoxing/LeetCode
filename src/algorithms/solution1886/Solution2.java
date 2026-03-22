package algorithms.solution1886;

public class Solution2 {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean[] fails = new boolean[4];
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] != target[i][j]) {
                    fails[0] = true;
                }
                if(mat[i][j] != target[j][n - 1 - i]) {
                    fails[1] = true;
                }
                if(mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    fails[2] = true;
                }
                if(mat[i ][j] != target[n - 1- j][i]) {
                    fails[3] = true;
                }
                if(fails[0] && fails[1] && fails[2] && fails[3]) {
                    return false;
                }
            }
        }
        return true;
    }
}
