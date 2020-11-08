package algorithms.solution771;

/**
 * 原地做，用charAt
 *
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public int numJewelsInStones(String J, String S) {
        int x = S.length();
        int y = J.length();
        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
