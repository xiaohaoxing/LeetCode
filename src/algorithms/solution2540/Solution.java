package algorithms.solution2540;

public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 0;
        if (nums1[0] > nums2[nums2.length - 1] || nums1[nums1.length - 1] < nums2[0]) {
            return -1;
        }
        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                return nums1[left];
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 4};
        Solution test = new Solution();
        int result = test.getCommon(a, b);
        System.out.println(result);
    }
}
