package algorithms.solution2938;

/**
 * 第一种方法将1移动到右边，其实直接将所有0移动到左边效果是一样的，还只需要1次循环
 */
public class Solution2 {
    public long minimumSteps(String s) {
        long result = 0L;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                result += i - left;
                left ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.minimumSteps("1100"));
    }
}
