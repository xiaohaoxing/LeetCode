package algorithms.solution942;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] diStringMatch(String S) {
        int[] result = new int[S.length() + 1];
        int upper = 1;
        int lower = -1;
        result[0] = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case 'I':
                    result[i + 1] = upper++;
                    break;
                case 'D':
                    result[i + 1] = lower--;
                    break;
            }
        }
        int lowest = 0;
        for (int i = 0; i < result.length; i++) {
            lowest = Math.min(lowest, result[i]);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - lowest;
        }
        return result;
    }
}
