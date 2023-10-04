package algorithms.solution834;

public class Solution {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[][] connnections = new int[n][n];
        for (int[] con : edges) {
            connnections[con[0]][con[1]] = 1;
            connnections[con[1]][con[0]] = 1;
        }
        return new int[0];
    }

    public boolean end(int[][] cons) {
        for (int i = 0; i < cons.length; i++) {
            for (int j = 0; j < cons[0].length; j++) {
                if (i == j) {
                    continue;
                }
                if (cons[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
