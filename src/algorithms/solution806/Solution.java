package algorithms.solution806;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if (S.isEmpty()) {
            return new int[]{0, 0};
        }
        int lineCount = 1;
        int width = 0;
        int MAX_WIDTH = 100;
        for (char c : S.toCharArray()) {
            if (widths[c - 'a'] > MAX_WIDTH - width) {
                lineCount += 1;
                width = widths[c - 'a'];
            } else {
                width += widths[c - 'a'];
            }
        }
        return new int[]{lineCount, width};
    }
}
