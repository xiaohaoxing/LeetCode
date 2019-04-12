package mioj;

import java.util.Scanner;

/**
 * 这里采用"找最长的单增、单减区间"
 */
public class Solution75_v2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] strs = line.split(",");
            if (strs.length == 1) {
                System.out.println("1");
                return;
            }
            int[] nums = new int[strs.length];
            // 考虑到相邻的相同的情况，这里采用递增和递减各扫描一遍的方式
            for (int i = 0; i < strs.length; i++) {
                int current = Integer.parseInt(strs[i]);
                nums[i] = current;
            }
            int longestIncrease = 1;
            int longestDecrease = 1;
            int increateEndIndex = 0;
            int decreateEndIndex = 0;
            int current = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    current = 1;
                    continue;
                } else {
                    current++;
                    if (current > longestIncrease) {
                        longestIncrease = current;
                        increateEndIndex = i;
                    }
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    current = 1;
                    continue;
                } else {
                    current++;
                    if (current > longestDecrease) {
                        longestDecrease = current;
                        decreateEndIndex = i;
                    }
                }
            }
            int longest;
            int lowest;
            if (longestDecrease > longestIncrease) {
                longest = longestDecrease;
                lowest = decreateEndIndex;
            } else {
                longest = longestIncrease;
                lowest = increateEndIndex - longest + 1;
            }
            //找到了增长、降低最长的地方了。向两侧分配糖果，红花增加就++，红花减少就分1个。完美
            int count = 1;
            if (lowest != 0) {
                int currentValue = 1;
                for (int i = lowest - 1; i >= 0; i--) {
                    if (nums[i] >= nums[i + 1]) {
                        currentValue++;
                        count += currentValue;
                    } else {
                        currentValue = 1;
                        count += currentValue;
                    }
                }
            }
            if (lowest != nums.length - 1) {
                int currentValue = 1;
                for (int i = lowest + 1; i < nums.length; i++) {
                    if (nums[i] >= nums[i - 1]) {
                        currentValue++;
                        count += currentValue;
                    } else {
                        currentValue = 1;
                        count += currentValue;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
