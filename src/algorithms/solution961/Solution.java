package algorithms.solution961;

import java.util.Arrays;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i <= A.length / 2; i++) {
            if (A[i] == A[i + A.length / 2 - 1]) {
                return A[i];
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[] test = {1,2,3,3};
        int result = new Solution().repeatedNTimes(test);
        System.out.println(result);
    }
}
