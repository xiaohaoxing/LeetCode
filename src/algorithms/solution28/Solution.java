package algorithms.solution28;

/**
 * 找出 haystack 中的 needle 的 index
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int backward = needle.length();
        if (backward == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();
        for (int i = 0; i <= chars.length - backward; i++) {
            if (match(chars, target, i)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean match(char[] chars, char[] target, int index) {
        boolean match = true;
        int i = index;
        for (char c : target) {
            if (chars[i] != c) {
                return false;
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) {
        String a = "aab";
        String b = "ab";
        Solution test = new Solution();
        int result = test.strStr(a, b);
        System.out.println(result);
    }
}
