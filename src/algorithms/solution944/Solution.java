package algorithms.solution944;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int minDeletionSize(String[] A) {
        int result = 0;
        if (A.length == 0) {
            return 0;
        }
        for (int i = 0; i < A[0].length(); i++) {
            boolean sorted = true;
            char current = 'a' - 1;
            for (int j = 0; j < A.length; j++) {
                if (A[j].charAt(i) >= current) {
                    current = A[j].charAt(i);
                } else {
                    sorted = false;
                    break;
                }
            }
            if (!sorted) {
                result++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] test = new String[]{"cba", "daf", "ghi"};
        int result = new Solution().minDeletionSize(test);
    }
}
