package algorithms.solution258;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public int addDigits(int num) {
        while (num > 9) {
            int result = 0;
            String str = String.valueOf(num);
            for (char c : str.toCharArray()) {
                result += c - '0';
            }
            num = result;
        }
        return num;
    }
}
