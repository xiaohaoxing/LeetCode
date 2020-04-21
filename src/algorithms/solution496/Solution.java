package algorithms.solution496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int pos = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    pos = j;
                    break;
                }
            }
            int value = -1;
            for (int j = pos + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    value = nums2[j];
                    break;
                }
            }
            result[i] = value;
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        int[] n1 = new int[]{4, 1, 2};
        int[] n2 = new int[]{1, 3, 4, 2};
        int[] result = new Solution().nextGreaterElement(n1, n2);
    }
}
