package algorithms.solution16;

public class Solution {
    /**
     * 要求找到nums中，3个数字之和，使其最接近于target。
     * 1.取2个数字，再用target减去2个之和得到expect，再从剩余中找最接近expect。就可以找到closest的结果。复杂度:O(n^2)
     *      用空间换了时间。
     * 2.暴力破解，直接求3个的和。然后保存那个差值作为结果。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        TwoSum[] twoSums = new TwoSum[nums.length * (nums.length - 1) / 2];
        // 得到所有的2个数字之和.并且记录它们的索引位置
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                twoSums[index] = new TwoSum(i, j, nums);
                index++;
            }
        }
        // 计算第三个数字
        int difference = target - twoSums[0].sum - nums[2];
        for (TwoSum sum : twoSums) {
            for (int i = 0; i < nums.length; i++) {
                if (sum.index1 != i && sum.index2 != i) {
                    int temp = target - sum.sum - nums[i];
                    if (Math.abs(temp) < Math.abs(difference)) {
                        difference = temp;
                    }
                }
            }
        }

        //得到最接近的结果
        return target - difference;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        int target = 0;
        Solution test = new Solution();
        int result = test.threeSumClosest(nums, target);
        System.out.println(result);
    }
}

class TwoSum {
    public TwoSum(int a, int b, int[] nums) {
        sum = nums[a] + nums[b];
        index1 = a;
        index2 = b;
    }

    /**
     * 2个数字之和
     */
    public int sum;
    /**
     * 第一个数字的索引位置
     */
    public int index1;
    /**
     * 第二个数字的索引位置
     */
    public int index2;
}
