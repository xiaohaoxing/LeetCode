package algorithms.solution1313;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int num = nums[i + 1];
            for (int j = 0; j < nums[i]; j++) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1, 1, 2, 3};
        Solution test = new Solution();
        int[] result = test.decompressRLElist(in);
        System.out.println(result);

    }
}
