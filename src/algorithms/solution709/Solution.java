package algorithms.solution709;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c > 64 && c < 91) {
                cs[i] = (char) (c + 32);
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {

        String hello = "HellO";
        Solution test = new Solution();
        System.out.println(test.toLowerCase(hello));
    }
}
