package algorithms.solution88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        int pos = 0;
        if (n == 0) {
            return;
        }
        while (a != m && b != n) {
            if (nums1[a] < nums2[b]) {
                a++;
                pos++;
            } else {
                int p = pos;
                int toBeMoved = nums1[p];
                while (nums1[p + 1] != 0) {
                    int tmp = nums1[p + 1];
                    nums1[p + 1] = toBeMoved;
                    toBeMoved = tmp;
                    p++;
                }
                nums1[p + 1] = toBeMoved;
                nums1[a] = nums2[b];
                pos++;
                b++;
            }
        }
        while (b < n) {
            nums1[nums1.length - nums2.length + b] = nums2[b];
            b++;
        }
        while (a < m) {
            a++;
        }
    }

    public static void main(String[] args) {
        // case 1
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = new int[]{2, 5, 6};
//        int n = 3;
        //case 2
//        int[] nums1 = new int[]{2, 0};
//        int m = 1;
//        int[] nums2 = new int[]{1};
//        int n = 1;
        // case 3
//        int[] nums1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
//        int[] nums2 = new int[]{1, 2, 2};
//        int m = 6;
//        int n = 3;
        // case 4
//        int[] nums1 = new int[]{0};
//        int m = 0;
//        int[] nums2 = new int[]{1};
//        int n = 1;
        // case 5
//        int[] nums1 = new int[]{4, 0, 0, 0, 0, 0};
//        int m = 1;
//        int[] nums2 = new int[]{1, 2, 3, 5, 6};
//        int n = 5;
        // case 6
        int[] nums1 = new int[]{0, 0, 3, 0, 0, 0, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{-1, 1, 1, 1, 2, 3};
        int n = 6;
        Solution test = new Solution();
        test.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }
}
