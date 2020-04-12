package algorithms.solution977;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        boolean needResort = true;
        if (A[0] >= 0) {
            needResort = false;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        if (!needResort) {
            return A;
        }
        int center = A.length - 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                center = i;
                break;
            }
        }
        int left = center - 1;
        int right = center + 1;
        int[] result = new int[A.length];
        int pos = 0;
        result[pos++] = A[center];
        while (left >= 0 && right < A.length) {
            if (A[left] < A[right]) {
                result[pos++] = A[left--];
            } else {
                result[pos++] = A[right++];
            }
        }
        if (right < A.length) {
            for (int i = right; i < A.length; i++) {
                result[pos++] = A[i];
            }
        }
        if (left >= 0) {
            for (int i = left; i >= 0; i--) {
                result[pos++] = A[i];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{-2};
        int[] result = new Solution().sortedSquares(test);
        System.out.println(result);
    }
}
