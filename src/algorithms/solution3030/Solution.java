package algorithms.solution3030;

import algorithms.utils.ListPrinter;

import java.util.Arrays;

/**
 * @author xiaohaoxing
 */
public class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        // init adjacent matrix
        boolean[][][] adj = new boolean[image.length][][];
        for (int i = 0; i < image.length; i++) {
            adj[i] = new boolean[image[0].length][];
            for (int j = 0; j < image[0].length; j++) {
                boolean right, down;
                if (i == image.length - 1) {
                    down = false;
                } else {
                    down = Math.abs(image[i + 1][j] - image[i][j]) <= threshold;
                }
                if (j == image[0].length - 1) {
                    right = false;
                } else {
                    right = Math.abs(image[i][j + 1] - image[i][j]) <= threshold;
                }

                adj[i][j] = new boolean[]{right, down};
            }
        }
        // init
        int[][] avg = new int[image.length][];
        int[][] finalAvg = new int[image.length][];
        for (int i = 0; i < image.length; i++) {
            avg[i] = new int[image[0].length];
            finalAvg[i] = new int[image[0].length];
            for (int j = 0; j < image[0].length; j++) {
                avg[i][j] = -1;
                finalAvg[i][j] = 0;
            }
        }
        // find 3*3 regions and calculate the average value
        for (int i = 0; i < adj.length - 2; i++) {
            for (int j = 0; j < adj[0].length - 2; j++) {
                boolean valid = adj[i][j][0] && adj[i][j][1] && adj[i][j + 1][0] && adj[i][j + 1][1]
                        && adj[i][j + 2][1] && adj[i + 1][j][0] && adj[i + 1][j][1] && adj[i + 1][j + 1][0]
                        && adj[i + 1][j + 1][1] && adj[i + 1][j + 2][1] && adj[i + 2][j][0] && adj[i + 2][j + 1][0];
                if (valid) {
                    avg[i + 1][j + 1] = (int) Math.floor((image[i][j] + image[i + 1][j] + image[i + 2][j] +
                            image[i][j + 1] + image[i + 1][j + 1] + image[i + 2][j + 1] +
                            image[i][j + 2] + image[i + 1][j + 2] + image[i + 2][j + 2]) / 9.0);
                }
            }
        }
        // find round 3*3 average for each cell to get final average.
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                int sum = 0;
                int count = 0;
                // each cell
                for (int x = Math.max(0, i - 1); x <= Math.min(image.length - 1, i + 1); x++) {
                    for (int y = Math.max(0, j - 1); y <= Math.min(image[0].length - 1, j + 1); y++) {
                        if (avg[x][y] != -1) {
                            count += 1;
                            sum += avg[x][y];
                        }
                    }
                }
                if (count > 0) {
                    finalAvg[i][j] = sum / count;
                } else {
                    finalAvg[i][j] = image[i][j];
                }
            }
        }
        return finalAvg;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        TestCase testCase = TestCase.case1();
        int[][] result = test.resultGrid(testCase.image, testCase.threshold);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }


    static class TestCase {
        public TestCase(int[][] image, int threshold) {
            this.image = image;
            this.threshold = threshold;
        }

        public int[][] image;
        public int threshold;

        public static TestCase case1() {
            return new TestCase(new int[][]{{5, 6, 7, 10}, {8, 9, 10, 10}, {11, 12, 13, 10}}, 3);
        }

        public static TestCase case2() {
            return new TestCase(new int[][]{{10, 20, 30}, {15, 25, 35}, {20, 30, 40}, {25, 35, 45}}, 13);
        }
    }
}
