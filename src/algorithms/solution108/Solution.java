package algorithms.solution108;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return partArrayToBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode partArrayToBST(int[] nums, int from, int to) {
        if (from == to) {
            return new TreeNode(nums[from]);
        }
        int center = (to - from) / 2 + from;
        TreeNode root = new TreeNode(nums[center]);
        if (center > from) {
            root.left = partArrayToBST(nums, from, center - 1);
        }
        if (center < to) {
            root.right = partArrayToBST(nums, center + 1, to);
        }
        return root;
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{-10, -3, 0, 5, 9};
        TreeNode result = new Solution().sortedArrayToBST(test);
        System.out.println(result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}