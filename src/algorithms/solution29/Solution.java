package algorithms.solution29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int adividend = Math.abs(dividend);
        int adivisor = Math.abs(divisor);
        int count = 0;
        while (adividend >= adivisor) {
            adividend = adividend - adivisor;
            count++;
        }
        return ((dividend > 0 ^ divisor > 0) ? -1 : 1) * count;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        Solution test = new Solution();
        int result = test.divide(a, b);
        System.out.println(result);
    }
}
