package algorithms.solution36;

/**
 * position info:
 * int[num}[order][x][y]:
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] nums = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = board[i][j] - 48;
                }
            }
        }
        // check each row
        int[] list = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                list[j] = nums[i][j];
            }
            if (!checkList(list)) {
                return false;
            }
        }

        //check each column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                list[j] = nums[j][i];
            }
            if (!checkList(list)) {
                return false;
            }
        }
        //check each sub block

        int[][] centers = new int[][]{{1, 1}, {4, 1}, {7, 1}, {1, 4}, {4, 4}, {7, 4}, {1, 7}, {4, 7}, {7, 7}};

        for (int[] center : centers) {
            System.out.println("checking around: (" + center[0] + ", " + center[1] + ").");
            int pos = 0;
            for (int shiftX = -1; shiftX < 2; shiftX++) {
                for (int shiftY = -1; shiftY < 2; shiftY++) {
                    list[pos++] = nums[center[0] + shiftX][center[1] + shiftY];
                }
            }
            if (!checkList(list)) {
                return false;
            }
        }
        return true;
    }


    private static boolean checkList(int[] list) {
        boolean[] flags = new boolean[10];
        for (int i = 0; i < 0; i++) {
            flags[i] = false;
        }
        for (int i : list) {
            if (i != 0) {
                if (flags[i] == true) {
                    return false;
                } else {
                    flags[i] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board2 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board3 = new char[][]{
                {'1', '.', '.', '2', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '5', '.', '1'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '3'},
                {'4', '.', '9', '5', '.', '.', '6', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '2', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '6', '8', '.', '.', '9', '.', '.'},
                {'9', '.', '.', '.', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        Solution test = new Solution();

        System.out.println(test.isValidSudoku(board3));
        boolean result = checkList(new int[]{0, 0, 0, 5, 0, 1, 8, 1, 3});
        System.out.println(result);
    }
}
