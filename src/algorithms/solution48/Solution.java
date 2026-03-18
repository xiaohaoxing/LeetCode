package algorithms.solution48;

import algorithms.utils.ListPrinter;
import algorithms.utils.MatrixPrinter;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,2},
            {3,4}
        };
        // int[][] matrix = new int[][] {
        //         { 1, 2, 3 },
        //         { 4, 5, 6 },
        //         { 7, 8, 9 }
        // };
        // int[][] matrix = new int[][]{
        // {1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12},
        // {13,14,15,16}
        // };
        Solution test = new Solution();
        test.rotate(matrix);
        MatrixPrinter.print(matrix);
    }

    public void rotate(int[][] matrix) {
        int middle = matrix.length / 2;
        int length = matrix.length;
        boolean isEven = matrix.length % 2 == 0;
        for (int i = 0; i < (isEven ? middle : middle + 1); i++) {
            for (int j = 0; j < middle; j++) {
                int[][] locations = new int[4][2];
                locations[0] = new int[] { i, j };
                locations[1] = new int[] {j, length - 1 - i};
                locations[2] = new int[] { length - 1 - i, length - 1 - j };
                locations[3] = new int[] {length - 1 - j, i};
                int temp = matrix[locations[3][0]][locations[3][1]];
                matrix[locations[3][0]][locations[3][1]] = matrix[locations[2][0]][locations[2][1]];
                matrix[locations[2][0]][locations[2][1]] = matrix[locations[1][0]][locations[1][1]];
                matrix[locations[1][0]][locations[1][1]] = matrix[locations[0][0]][locations[0][1]];
                matrix[locations[0][0]][locations[0][1]] = temp;
            }
        }
    }
}
