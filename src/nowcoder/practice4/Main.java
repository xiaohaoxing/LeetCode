package nowcoder.practice4;

public class Main {

    public static void main(String[] args) {
//        System.out.println(getFactorSum(10));
        System.out.println(getFactorSum(6));
    }

    public static int getFactorSum(int n) {
        int ceil = (int) Math.sqrt(n);
        for (int i = 2; i <= ceil; i++) {
            if (n % i == 0) {
                return i + getFactorSum(n / i);
            }
        }
        return n + 1;
    }
}
