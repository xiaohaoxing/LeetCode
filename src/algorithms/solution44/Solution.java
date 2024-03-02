package algorithms.solution44;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // empty p
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        // empty s
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        TestCase testCase = test.case1();
        boolean result = test.isMatch(testCase.s, testCase.p);
        System.out.println(testCase.s + (result ? " matches " : " don't match ") + testCase.p);
    }

    class TestCase {
        String s;
        String p;

        public TestCase(String a, String b) {
            s = a;
            p = b;
        }
    }

    /**
     * passed
     */
    private TestCase case1() {
        return new TestCase("zacabz", "*a?b*");
    }

    private TestCase case2() {
        return new TestCase("", "*****");
    }

    private TestCase case3() {
        return new TestCase("acdcb", "a*c?b");
    }

    private TestCase case4() {
        return new TestCase("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b");
    }

    private TestCase case5() {
        return new TestCase("adceb", "*a*b");
    }
}
