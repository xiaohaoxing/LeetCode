package algorithms.solution500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap(){{
            put('q', 1);put('Q', 1);
            put('w', 1);put('W', 1);
            put('e', 1);put('E', 1);
            put('r', 1);put('R', 1);
            put('t', 1);put('T', 1);
            put('y', 1);put('Y', 1);
            put('u', 1);put('U', 1);
            put('i', 1);put('I', 1);
            put('o', 1);put('O', 1);
            put('p', 1);put('P', 1);
            put('a', 2);put('A', 2);
            put('s', 2);put('S', 2);
            put('d', 2);put('D', 2);
            put('f', 2);put('F', 2);
            put('g', 2);put('G', 2);
            put('h', 2);put('H', 2);
            put('j', 2);put('J', 2);
            put('k', 2);put('K', 2);
            put('l', 2);put('L', 2);
            put('z', 3);put('Z', 3);
            put('x', 3);put('X', 3);
            put('c', 3);put('C', 3);
            put('v', 3);put('V', 3);
            put('b', 3);put('B', 3);
            put('n', 3);put('N', 3);
            put('m', 3);put('M', 3);
        }};
        List<String> result = new ArrayList<String>();
        for(String s:words) {
            int row = map.get(s.charAt(0));
            for(char c: s.toCharArray()) {
                if(map.get(c) != row){
                    row = 0;
                    break;
                }
            }
            if(row != 0) {
                result.add(s);
            }
        }
        return result.toArray(new String[0]);
    }
}
