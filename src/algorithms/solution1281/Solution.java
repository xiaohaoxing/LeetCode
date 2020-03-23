package algorithms.solution1281;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        String num = String.valueOf(n);
        int prod = 1;
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            prod *= (num.charAt(i) - 48);
            sum += (num.charAt(i) - 48);
        }
        return prod - sum;
    }

    public static void main(String[] args) {
        System.out.println((int)'0');
    }
}
