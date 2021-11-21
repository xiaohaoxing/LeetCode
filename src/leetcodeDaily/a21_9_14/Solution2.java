package leetcodeDaily.a21_9_14;

public class Solution2 {

    public int superpalindromesInRange(String left, String right) {
        int count = 0;
        long start = getStart2(left);
        long limit = Long.parseLong(right);
        while (true) {
            long[] palins = genPalin(String.valueOf(start));
            long one = palins[0] * palins[0];
            if (one > limit) {
                break;
            }
            if (isPalindromes(one)) {
                count++;
            }
            if (isPalindromes(palins[1] * palins[1])) {
                count++;
            }
            start++;
        }
        return count;
    }

    long getStart2(String str) {
        Long val = Long.valueOf(str);
        Double root = Math.sqrt(val.doubleValue());
        return getStart(String.valueOf(root));
    }
    long getStart(String str) {
        int len = str.length();
        long result = 1;
        int digit;
        if (len % 2 == 1) {
            digit = (len - 1) / 2;
            for (int i = 0; i < digit; i++) {
                result *= 10;
            }
            return result;
        } else {
            digit = len / 2;
            result = 3;
            for (int i = 0; i < digit - 1; i++) {
                result *= 10;
                result += 1;
            }
            return result;
        }
    }

    long[] genPalin(String str) {
        char[] src = str.toCharArray();
        int size = str.length();
        char[] result1 = new char[str.length() * 2];
        char[] result2 = new char[str.length() * 2 - 1];
        for (int i = 0; i < src.length; i++) {
            result1[i] = src[i];
            result2[i] = src[i];
        }
        for (int i = 0; i < size; i++) {
            result1[i + size] = src[size - i - 1];
        }
        for (int i = 0; i < size - 1; i++) {
            result2[i + size] = src[size - i - 2];
        }
        return new long[]{Long.parseLong(new String(result2)), Long.parseLong(new String(result1))};
    }

    boolean isPalindromes(long num) {
        String str = String.valueOf(num);
        return isPalindromes(str);
    }

    boolean isPalindromes(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.getStart("1000"));
        System.out.println(test.getStart("10000"));
        System.out.println(test.getStart("100000"));

        long[] results = test.genPalin("1234");
        System.out.println("[" + results[0] + "," + results[1] + "]");

        String left = "4";
        String right = "1000";

        System.out.println(test.superpalindromesInRange(left, right));
    }
}
