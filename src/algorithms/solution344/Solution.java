package algorithms.solution344;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public void reverseString(char[] s) {
        int count = s.length / 2;
        char tmp;
        for (int i = 0; i < count; i++) {
            tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }


    public static void main(String[] args) {
        char[] in = "hello".toCharArray();
        Solution test = new Solution();
        test.reverseString(in);
        System.out.println(new String(in));
    }
}
