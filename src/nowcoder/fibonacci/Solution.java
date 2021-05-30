package nowcoder.fibonacci;

/**
 * @author 肖皓星
 */
public class Solution {
    public static int[] record;

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int left = 0;
        int right = 1;
        int target = left + right;
        int targetIndex = 2;
        while (targetIndex < n) {
            targetIndex += 1;
            left = right;
            right = target;
            target = left + right;
        }
        return target;
//        record = new int[n + 1];
//        record[0] = 0;
//        record[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            record[i] = record[i - 1] + record[i - 2];
//        }
//        return record[n];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.Fibonacci(4));
    }
}
