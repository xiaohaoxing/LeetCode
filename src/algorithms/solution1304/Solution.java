package algorithms.solution1304;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        if (n % 2 == 1) {
            result[index++] = 0;
        }
        int current = 1;
        for (; index < n - 1; ) {
            result[index++] = current;
            result[index++] = -current;
            current++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int test = 4;
        int[] result = new Solution().sumZero(test);
        System.out.println(result);
    }
}
