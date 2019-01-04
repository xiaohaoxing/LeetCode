package algorithms.solution33;

/**
 * 这么运行也是可以通过的，但是时间复杂度上明显不是O(n*logn)
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
