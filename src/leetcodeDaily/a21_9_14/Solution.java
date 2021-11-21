package leetcodeDaily.a21_9_14;

public class Solution {
    public int superpalindromesInRange(String left, String right) {
        int count = 0;
        // find the sqrt of left
        Double lowestDouble = Math.sqrt(Double.parseDouble(left));
        Double e = 1e-10;
        Long highest = Long.parseLong(right);
        Long current;
        if (lowestDouble - Math.floor(lowestDouble) < e) {
            current = lowestDouble.longValue();
        } else {
            current = Double.valueOf(Math.ceil(lowestDouble)).longValue();
        }
        while (true) {
            long sqr = current * current;
            if (sqr > highest) {
                break;
            }
            if (isPalindromes(current) && isPalindromes(sqr)) {
                count++;
            }
            current++;
        }
        return count;
    }

    boolean isPalindromes(long num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }


    public static void main(String[] args) {
        String left = "40000000000000000";
        String right = "50000000000000000";
        Solution test = new Solution();
        int result = test.superpalindromesInRange(left, right);
        System.out.println(result);
    }
}


