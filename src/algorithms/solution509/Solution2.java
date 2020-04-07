package algorithms.solution509;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public int fib(int N) {
        if(N < 2) {return N;}
        int left = 0;
        int right = 1;
        while(N > 1) {
            int sum = left + right;
            left = right;
            right = sum;
            N --;
        }
        return right;
    }
}
