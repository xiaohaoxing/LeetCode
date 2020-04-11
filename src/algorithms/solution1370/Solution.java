package algorithms.solution1370;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String sortString(String s) {
        short[] counts = new short[26];
        for (char c : s.toCharArray()) {
            counts[c - 97]++;
        }
        boolean remained = true;
        StringBuilder sb = new StringBuilder();
        while (remained) {
            remained = false;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    sb.append((char) (i + 'a'));
                    counts[i]--;
                    remained = true;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    sb.append((char) (i + 'a'));
                    counts[i]--;
                    remained = true;
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String test = "aaaabbbbcccc";
        String result = new Solution().sortString(test);
        System.out.println(result);
    }
}