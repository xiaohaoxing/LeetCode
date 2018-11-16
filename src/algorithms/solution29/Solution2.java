package algorithms.solution29;

public class Solution2 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor > 0) {
                while (dividend <= -divisor) {
                    dividend += divisor;
                    count--;
                }
                return count;
            } else {
                while (dividend <= divisor) {
                    dividend -= divisor;
                    count++;
                }
                return count;
            }
        }
        int adividend = Math.abs(dividend);
        int adivisor = Math.abs(divisor);
        while (adividend >= adivisor) {
            adividend = adividend - adivisor;
            count++;
        }
        return ((dividend > 0 ^ divisor > 0) ? -1 : 1) * count;
    }

    public static void main(String[] args) {
        int a = -999511578;
        int b = -2147483648;
        Solution2 test = new Solution2();
        int result = test.divide(a, b);
        System.out.println(result);
        System.out.println(-999511578 < -2147483648);
    }
}
