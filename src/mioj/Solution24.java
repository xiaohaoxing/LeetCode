package mioj;

import java.util.Scanner;

public class Solution24 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] numStrs = line.split(",");
            int[] nums = new int[numStrs.length];
            int sum = 0;
            for (int i = 0; i < numStrs.length; i++) {
                int num = Integer.parseInt(numStrs[i]);
                sum += num;
                nums[i] = num;
            }
            int target = sum / 2;

            for (int i = 0; i < nums.length; i++) {
                int result = approchTarget(nums, target, i);
                if (result == 0) {
                    System.out.println("true");
                    return;
                }
            }
            System.out.println("false");

        }
    }

    public static int approchTarget(int[] nums, int target, int pos) {
//        boolean result = false;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;//当前的已经大过目标了，不行
            } else if (nums[i] < target) {
                return approchTarget(nums, target - nums[pos], i + 1);// 当前比目标小，继续找
            } else {
                return 0;//当前的刚好=目标，结束啦
            }
        }
        return -1;// 找不到凑成目标的值。
    }
}
