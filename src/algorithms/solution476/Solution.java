package algorithms.solution476;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int findComplement(int num) {
        int sum = 1;
        while(sum < num) {
            sum = sum * 2 + 1;
        }
        return sum - num;
    }
}
