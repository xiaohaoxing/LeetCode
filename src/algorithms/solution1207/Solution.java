package algorithms.solution1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i:arr) {
            if(count.containsKey(i)) {
                count.put(i, count.get(i) + 1);
            }else{
                count.put(i, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : count.entrySet()) {
            if(set.contains(integerIntegerEntry.getValue())) {
                return false;
            }else{
                set.add(integerIntegerEntry.getKey());
            }
        }
        return true;
    }
    
    
}
