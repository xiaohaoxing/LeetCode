package leetcodeDaily.a21_4_6;

/**
 * @author 肖皓星
 */
public class Solution {
    public int minOperations(int n) {
        return n % 2 == 0 ? (n / 2 * n / 2) : ((n - 1) * (n + 1) / 4);
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        for (int i = 0; i < 7; i++) {
            System.out.println("the result is " + test.minOperations(i) + " when n=" + i);
        }
    }
}


