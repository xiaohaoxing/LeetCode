package algorithms.Solution287;

public class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] exists = new boolean[10000];
        for (int i : nums) {
            if (exists[i - 1]) {
                return i;
            }
            exists[i - 1] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 3, 4, 2, 2};
        Solution test = new Solution();
        int result = test.findDuplicate(case1);
        System.out.println(result);
    }
}
