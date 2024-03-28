package bytedance;

public class Solution2 {
    public int shortestSubString(int[] a, int s) {
        int sum;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                if (sum >= s) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                    }
                    break;
                }
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 1};
        int s = 7;
        Solution2 test = new Solution2();
        int result = test.shortestSubString(a, s);
        System.out.println(result);
    }
}
