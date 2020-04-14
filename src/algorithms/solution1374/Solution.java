package algorithms.solution1374;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String generateTheString(int n) {
        if (n % 2 == 1) {
            return generateOddString(n - 1) + "c";
        }
        return generateOddString(n);
    }
    
    public String generateOddString(int n) {
        if(n == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }
        sb.append('b');
        return sb.toString();
    }
}
