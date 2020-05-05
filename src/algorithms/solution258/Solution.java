package algorithms.solution258;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int addDigits(int num) {
        if(num > 9) {
            String str = String.valueOf(num);
            int result = 0;
            for(char c: str.toCharArray()) {
                result += c-'0';
            }
            return addDigits(result);
        }else {
            return num;
        }
    }
    
    public static void main(String[] args) {
        int num = 38;
        int result = new Solution().addDigits(num);
        System.out.println(result);
    }
}
