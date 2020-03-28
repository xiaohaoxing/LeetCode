package algorithms.solution657;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
                case 'U':
                    v--;
                    break;
                case 'D':
                    v++;
                    break;
                default:
            }
        }
        return v == 0 && h == 0;
    }
}
