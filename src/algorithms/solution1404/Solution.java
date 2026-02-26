package algorithms.solution1404;

public class Solution {

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int counts = 0;
        while(sb.length() > 1) {
            if(sb.charAt(sb.length() - 1) == '1') {
                System.out.println("odd to add 1 to number");
                // add one
                int idx = sb.length() - 1;
                while(idx >= 0 && sb.charAt(idx) == '1') {
                    sb.setCharAt(idx, '0');
                    idx --;
                }
                if(idx < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(idx, '1');
                }
            } else {
                System.out.println("even to divide 2 to number");
                sb.deleteCharAt(sb.length() - 1);
            }
            counts ++;
        }
        return counts;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int result = test.numSteps("1101");
        System.out.println(result);
    }
}
