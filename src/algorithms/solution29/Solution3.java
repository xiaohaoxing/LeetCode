package algorithms.solution29;

/**
 * 采用诸位去相减的方法。
 */
public class Solution3 {

//    public int divide(int dividend, int divisor) {
//        if(dividend == 0) {
//            return 0;
//        }
//        if (dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//        int adividend = dividend>0?dividend:-dividend;
//        int adivisor = divisor>0?divisor:-divisor;
//        char[] dividends = ("" + adividend).toCharArray();
//        int current = 0;
//        for(char d:dividends) {
//
//        }
//    }

    public static int divideOne(int a, int b) {
        int current = a;
        int count = 0;
        while (current > b) {
            current -= b;
            count++;
        }
        return count;

    }


}
