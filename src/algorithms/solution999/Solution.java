package algorithms.solution999;

/**
 * @author 肖皓星
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
        char target = 'R';
        int height = board.length;
        int width = board[0].length;
        int x = 0;
        int y = 0;
        // find target
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == target) {
                    x = i;
                    y = j;
                }
            }
        }
        return left(board, x, y) + right(board, x, y) + up(board, x, y) + down(board, x, y);
    }

    public int up(char[][] board, int x, int y) {
        for (int i = x - 1; i > 0; i--) {
            switch (board[i][y]) {
                case 'p':
                    return 1;
                case 'B':
                    return 0;
                default:
                    break;
            }
        }
        return 0;
    }

    public int down(char[][] board, int x, int y) {
        for (int i = x + 1; i < board.length; i++) {
            switch (board[i][y]) {
                case 'p':
                    return 1;
                case 'B':
                    return 0;
                default:
                    break;
            }
        }
        return 0;
    }

    public int left(char[][] board, int x, int y) {
        for (int i = y - 1; i > 0; i--) {
            switch (board[x][i]) {
                case 'p':
                    return 1;
                case 'B':
                    return 0;
                default:
                    break;
            }
        }
        return 0;
    }

    public int right(char[][] board, int x, int y) {
        for (int i = y + 1; i < board[0].length; i++) {
            switch (board[x][i]) {
                case 'p':
                    return 1;
                case 'B':
                    return 0;
                default:
                    break;
            }
        }
        return 0;
    }

}
