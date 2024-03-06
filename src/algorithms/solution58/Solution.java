package algorithms.solution58;

/**
 * 1. contains tail space
 * 2. contains single word without space
 * @author xiaohaoxing
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int lastWordStart = 0;
        int lastWordEnd = 0;
        int lastSpace = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastSpace = i;
            } else {
                lastWordStart = lastSpace + 1;
                lastWordEnd = i;
            }
        }
        return lastWordEnd - lastWordStart + 1;
    }


    public static void main(String[] args) {
        String a = "hello world";
        Solution test = new Solution();
//        int result = test.lengthOfLastWord(a);
//        assert result == 5;
//        assert test.lengthOfLastWord("    ") == 0;
//        System.out.println(test.lengthOfLastWord("  fly me to the moon   "));
        System.out.println(test.lengthOfLastWord("  fly me to the moon   "));
    }
}
