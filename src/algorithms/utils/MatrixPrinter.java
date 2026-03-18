package algorithms.utils;

public class MatrixPrinter {
    public static void print(int[][] matrix) {
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        for (int[] row : matrix) {
            if (row == null) {
                System.out.println("null");
                continue;
            }
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
