package algorithms.solution1051;

import java.util.Arrays;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] result = Arrays.copyOf(heights,heights.length);
        Arrays.sort(result);
        for (int i = 0; i < heights.length; i++) {
            if(result[i] != heights[i]) {
                count ++;
            }
        }
        return count;
    }
}
