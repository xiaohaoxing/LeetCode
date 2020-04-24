package algorithms.solution821;

import algorithms.utils.ListPrinter;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        char[] chars = S.toCharArray();
        // 初始化为溢出值
        for (int i = 0; i < S.length(); i++) {
            result[i] = S.length();
        }
        for (int i = 0; i < chars.length; i++) {
            if (C == chars[i]) {
                int dis = 0;
                int idx = i;
                while (idx >= 0 && result[idx] > dis) {
                    result[idx--] = dis++;
                }
                dis = 1;
                idx = i + 1;
                while (idx < result.length && result[idx] > dis) {
                    result[idx++] = dis++;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        String s = "loveleetcode";
        char c = 'e';
        int[] result = new Solution().shortestToChar(s, c);
        ListPrinter.printArray(result);
    }
}
