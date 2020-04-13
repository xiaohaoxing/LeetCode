package algorithms.solution1309;

import java.util.Stack;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> result = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                result.push((char) (s.charAt(i - 1) - '0' + 10 * (s.charAt(i - 2) - '0') + 96));
                i = i - 2;
            } else {
                result.push((char) (s.charAt(i) + 48));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!result.empty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        String test = "10#11#12";
        String result = new Solution().freqAlphabets(test);
        System.out.println(result);
    }
}
