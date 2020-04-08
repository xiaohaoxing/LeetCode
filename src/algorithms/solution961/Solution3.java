package algorithms.solution961;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution3 {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if(counts.containsKey(A[i])){
                counts.put(A[i], counts.get(A[i])+1);
            }else{
                counts.put(A[i], 1);
            }
        }
        AtomicInteger result = new AtomicInteger();
        counts.forEach((k,v)->{
            if(v == A.length/2) {
                result.set(k);
            }
        });
        return result.get();
    }
}
