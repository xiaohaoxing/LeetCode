package algorithms.solution1221;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int balancedStringSplit(String s) {
        short result = 0;
        short count = 0;
        for(char c:s.toCharArray()) {
            if(c == 'L') {
                count -= 1;
            }
            if(c == 'R') {
                count += 1;
            }
            if(count == 0) {
                result += 1;
            }
        }
        return result;
    }
}
