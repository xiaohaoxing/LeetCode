
/**
 * 这里是用位运算替代乘方运算，实现对被除数的 N 进制（N = divisor）切分。可以优化的地方是：用空间换时间，把 N 次方的值保存在数组中复用。
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0;
        boolean minus = dividend > 0 != divisor > 0;
        long ldividend = Long.valueOf(dividend);
        long ldivisor = Long.valueOf(divisor);
        if (dividend < 0) {
            ldividend = -ldividend;
        }
        if (divisor < 0) {
            ldivisor = -ldivisor;
        }
        long remaining = ldividend;
        while (remaining >= ldivisor) {
            int curTimes = 1;
            long curCount = ldivisor;
            while (curCount << 1 < remaining) {
                curCount = curCount << 1;
                curTimes = curTimes + curTimes;
            }
            result += curTimes;
            remaining = remaining - curCount;
        }
        if (minus && result > Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (!minus && result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return minus ? (int)-result : (int)result;
    }

    public static void main(String[] args) {
        int a = -2147483648;
        int b = -1;
        Solution test = new Solution();
        int result = test.divide(a, b);
        System.out.println(result);
    }
}
