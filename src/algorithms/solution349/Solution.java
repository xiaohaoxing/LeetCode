package algorithms.solution349;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        int[] tmp = new int[nums2.length];
        int idx = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                tmp[idx++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOf(tmp, idx);
    }
    
    
    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 2, 1};
        int[] n2 = new int[]{2, 2};
        int[] result = new Solution().intersection(n1, n2);
        
    }
}
