package algorithms.solution575;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> count = new HashSet<>();
        for (int i : candies) {
            count.add(i);
        }
        return Math.min(count.size(), candies.length / 2);
    }
}
}
