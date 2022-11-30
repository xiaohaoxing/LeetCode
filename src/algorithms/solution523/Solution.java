package algorithms.solution523;

/**
 * 要求目标的数组中包含一个子序列，总和是 k 的倍数
 * 先把所有数字对 k 求余，然后用双指针依次找总和为 k 的子序列。
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % k;
        }
        for (int i = 0; i < nums.length; i++) {
            if (find(nums, i, i + 1, k, nums[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean find(int[] nums, int from ,int to,  int k, int sum) {
        while (to < nums.length) {
            sum += nums[to];
            System.out.println("[" + from + "," + to + "]");
            if(sum == 0){
                return true;
            }
            if (sum > k) {
                if (find(nums, from, to + 1, k, sum - k)){
                    return true;
                }
                while (sum > k) {
                    sum -= nums[from];
                    from++;
                }
            }
            if (sum == k) {
                return true;
            }
            to++;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 2, 1, 5};
//        int[] arr = new int[]{23, 2, 4, 6, 6};
        int[] arr = new int[]
//                {5,0,0,0};
//                {23,6,9};
                {0,0};
        int num = 1;
        Solution solution = new Solution();
        boolean result = solution.checkSubarraySum(arr, num);
        System.out.println("result is " + result);
    }

}

