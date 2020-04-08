package algorithms.solution961;

import java.util.Arrays;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int left = A[A.length / 2 - 1];
        int right = A[A.length / 2];
        if(left == right) {
            return left;
        } else {
            if(left == A[0]) {
                return left;
            } else {
                return right;
            }
        }
    }
}
