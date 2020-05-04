package algorithms.solution908;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = A[0];
        int min = A[0];
        for (int i : A) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        return (max - min) > 2 * K ? (max - min - 2 * K) : 0;
    }
}
