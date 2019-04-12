package algorithms.solution136;

/**
 * 仍然寻找规定的线性时间内和无额外空间
 */
public class Solution3 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
