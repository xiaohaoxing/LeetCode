package algorithms.solution1750;

public class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[s.length()];
        int left = 0;
        int right = 0;
        char last = '0';
        for (char c : s.toCharArray()) {
            if (c != last) {
                arr[right] = c;
                right++;
                last = c;
            }
        }
        right -= 1;
        int result = 0;
        while (left < right && arr[left] == arr[right]) {
            result += 1;
            left += 1;
            right -= 1;
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "cabaabac";
        Solution test = new Solution();
        int result = test.minimumLength(s);
        System.out.println(result);
    }
}
