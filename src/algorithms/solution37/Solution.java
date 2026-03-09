package algorithms.solution37;

import algorithms.utils.ListPrinter;

/**
 * 初始化：
 * 把所有空格的可能性都填充完。
 * 迭代：
 * 遍历空格，把只有一个可能性的空格填充，从 EmptyBlock 替换为 ValueBlock，然后扩充本行，本列，本子表其他空格的值.
 * 直到所有的空格被填充完毕。
 * 
 * 
 * TODO 下一步应该是实现唯一可能格点的填充。
 */
public class Solution {
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean solved = false;

    public static void main(String[] args) {
        System.out.println(0 + '0');
        System.out.println(0 + '1');
        char[][] test = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        ListPrinter.printTable(test);
        Solution sol = new Solution();
        sol.solveSudoku(test);
        ListPrinter.printTable(test);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.board[i][j] != '.') {
                    this.placeNumber(this.board[i][j] - '0', i, j);
                }
            }
        }
        this.backtrack(0, 0);
    }

    public boolean canPlace(int d, int i, int j) {
        int idx = (i / n) * n + j / n;
        return rows[i][d] + cols[j][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int i, int j) {
        int idx = (i / n) * n + j / n;
        rows[i][d] ++;
        cols[j][d] ++;
        boxes[idx][d] ++;
        board[i][j] = (char)(d+'0');
    }

    public void removeNumber(int d, int i, int j) {
        int idx = (i / n) * n + j / n;
        rows[i][d] --;
        cols[j][d] --;
        boxes[idx][d] --;
        board[i][j] = '.';
    }

    public void placeNextNumbers(int i, int j) {
        if(i == N - 1 && j == N -1) {
            solved = true;
        } else if(j == N - 1) {
            backtrack(i+1, 0);
        } else {
            backtrack(i, j+1);
        }
    }

    public void backtrack(int i, int j) {
        if(board[i][j] == '.') {
            for(int d = 1; d <= 9; d ++) {
                if(canPlace(d, i, j)) {
                    placeNumber(d, i, j);
                    placeNextNumbers(i, j);
                    if(!solved) {
                        removeNumber(d, i, j); // 这里保证了递归回溯能回到上一个空位置
                    }
                }
            }
        } else {
            placeNextNumbers(i , j);
        }
    }

    public static int trySolve(char[][] nums) {
        boolean hasEmpty = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == '.') {
                    System.out.println("trying solve:[" + i + "][" + j + "]");
                    hasEmpty = true;
                    //遇到空格
                    boolean[] poss = new boolean[10];
                    for (int k = 0; k < 10; k++) {
                        poss[k] = true;
                    }
                    int count = '1' + '2' + '3' + '4' + '5' + '6' + '7' + '8' + '9';
                    int current;
                    // check row
                    for (int k = 0; k < 9; k++) {
                        current = nums[i][k];

                        if (current != '.' && poss[current - 48]) {
                            count -= current;
                            poss[current - 48] = false;
                        }

                    }
                    // check column
                    for (int k = 0; k < 9; k++) {
                        current = nums[k][j];
                        if (current != '.' && poss[current - 48]) {
                            count -= current;
                            poss[current - 48] = false;
                        }

                    }
                    // check round
                    int xFrom = i / 3;
                    xFrom *= 3;
                    int yFrom = j / 3;
                    yFrom *= 3;
                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            current = nums[xFrom + m][yFrom + n];
                            if (current != '.' && poss[current - 48]) {
                                count -= current;
                                poss[current - 48] = false;
                            }

                        }
                    }
                    System.out.println("possible sum:" + count);
                    if (count == 0) {
                        return -1;
                    } else if (count <= '9') {
                        System.out.println("Solved [" + i + "][" + j + "] with value" + (char) count);
                        nums[i][j] = (char) count;
                        return 1;
                    }
                }
            }
        }
        if (hasEmpty) {
            return -1;
        } else {
            return 0;
        }
    }
}