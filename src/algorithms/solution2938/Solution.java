package algorithms.solution2938;

/**
 * @Pass
 * 将所有的1移动到最右边，那么2个指针，将left移动到right所需的cost之和即可。
 */
public class Solution {
    public long minimumSteps(String s) {
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right += 1;
            }
        }
        right = s.length() - right;
        long result = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                System.out.printf("把第%d个元素移动到第%d个元素，最终结果增加%d%n", i + 1, right + 1, right - i);
                result += (right - i);
                right += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "110";
        System.out.println(solution.minimumSteps(test));
    }
}
