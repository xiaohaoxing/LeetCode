package algorithms.solution1727;
import java.util.Arrays;
import algorithms.utils.ListPrinter;

public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        Integer[][] heightMatrix = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++) {
            heightMatrix[i] = new Integer[matrix[0].length];
            for(int j = 0; j < matrix[0].length; j ++) {
                heightMatrix[i][j] = matrix[i][j] == 0?0:1 + (i == 0?0:heightMatrix[i-1][j]);
            }
        }
        int max = 0;
        // ListPrinter.printTable(heightMatrix);
        for(int i = 0; i < matrix.length; i ++) {
            Arrays.sort(heightMatrix[i]);
            int k = matrix[i].length - 1;
            while(k >= 0 && heightMatrix[i][k] != 0) {
                int current = (heightMatrix[i].length - k) * heightMatrix[i][k];
                if(current > max) {
                    // System.out.println("I found " + i + " row with width " + (heightMatrix[i].length - k) + " is the biggest.");
                    max = current;
                }
                k --;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[][] case1 = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1},{0,1,1,0,1,1,1,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1}
        };
        Solution test = new Solution();
        int result = test.largestSubmatrix(case1);
        System.out.println(result);
    }
}
