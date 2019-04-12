package algorithms.solution136;

public class Solution2 {
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    nums[i] = 0;
                    nums[j] = 0;
                }
            }
        }
        for (int n : nums) {
            if (n != 0) {
                return n;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] list = new int[]{4, 1, 2, 1, 2};
        Solution test = new Solution();
        int result = test.singleNumber(list);
        System.out.println(result);
    }
}
