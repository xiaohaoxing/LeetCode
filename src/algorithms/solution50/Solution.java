package algorithms.solution50;

public class Solution {
    public double myPow(double x, int n) {
        boolean exceed = false;
        if (n == 1) {
            return x;
        } else if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                exceed = true;
                n = n + 1;
            }
            n = -n;
            x = 1 / x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (exceed) {
            return x * myPow2(x, n);
        } else {
            return myPow2(x, n);
        }
    }

    public double myPow2(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPow2(x * x, n / 2);
        } else {
            return x * myPow(x * x, (n - 1) / 2);
        }
    }

    public static void main(String[] args) {
        double x = 34.00515;
        int n = -3;
        Solution test = new Solution();
        double result = test.myPow(x, n);
        System.out.println(result);
    }
}
