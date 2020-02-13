package algorithms.solution42;

import java.util.concurrent.BrokenBarrierException;

/**
 * @author 肖皓星
 * @email xiaohaoxing@xiaomi.com
 * @date 2020/2/13 21:47
 */
public class Solution {
    public int trap(int[] height) {
        int border = highestIndex(height, 0, height.length - 1);
        return trapLeft(height, 0, border) + trapRight(height, border, height.length - 1);
    }

    public int trapRight(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return 0;
        }
        int highest = highestIndex(arr, left + 1, right);
        return fillPartial(arr, left, highest) + trapRight(arr, highest, right);
    }

    public int trapLeft(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return 0;
        }
        int highest = highestIndex(arr, left, right - 1);
        return trapLeft(arr, left, highest) + fillPartial(arr, highest, right);
    }

    public int fillPartial(int[] arr, int left, int right) {
        int top = Math.min(arr[left], arr[right]);
        int count = 0;
        for (int i = left + 1; i < right; i++) {
            count += top - arr[i];
        }
        return count;
    }

    public int highestIndex(int[] arr, int left, int right) {
        int highest = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > arr[highest]) {
                highest = i;
            }
        }
        return highest;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution test = new Solution();
        System.out.println(test.trap(height));
    }
}
