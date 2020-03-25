package algorithms.solution461;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String xorStr = Integer.toBinaryString(xor);
        char[] chars = xorStr.toCharArray();
        int result = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println("" + test.hammingDistance(1, 4));

    }
}
