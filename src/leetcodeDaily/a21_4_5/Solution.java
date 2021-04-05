package leetcodeDaily.a21_4_5;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 2; j < A.length; j++) {
                if (A[i] > A[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 0};
        Solution test = new Solution();
        System.out.println(test.isIdealPermutation(A));
    }
}