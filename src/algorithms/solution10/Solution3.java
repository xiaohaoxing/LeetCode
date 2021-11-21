package algorithms.solution10;

public class Solution3 {
    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public boolean match(char[] target, int targetIndex, char[] pattern, int patternIndex) {
        if (targetIndex == target.length && patternIndex == pattern.length) {
            return true;
        }
        if (targetIndex >= target.length || patternIndex >= pattern.length) {
            return false;
        }
        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            return matchMulti(target, targetIndex, pattern, patternIndex);
        }
        return matchSingle(target, targetIndex, pattern, patternIndex) && match(target, targetIndex + 1, pattern, patternIndex + 1);
    }

    public boolean matchMulti(char[] target, int targetIndex, char[] pattern, int patternIndex) {
        if (targetIndex == target.length - 1 && patternIndex + 2 == pattern.length) {
            return true;
        }
        if (targetIndex >= target.length || patternIndex >= pattern.length) {
            return false;
        }
        do {
            if (match(target, targetIndex, pattern, patternIndex + 2)) {
                return true;
            }
            targetIndex++;
        } while (matchSingle(target, targetIndex, pattern, patternIndex));
        return match(target, targetIndex, pattern, patternIndex + 2);
    }

    public boolean matchSingle(char[] target, int targetIndex, char[] pattern, int patternIndex) {
        return targetIndex < target.length && patternIndex < pattern.length && (target[targetIndex] == pattern[patternIndex] || pattern[patternIndex] == '.');
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        Solution3 test = new Solution3();
        System.out.println(test.isMatch(s, p));
    }
}
