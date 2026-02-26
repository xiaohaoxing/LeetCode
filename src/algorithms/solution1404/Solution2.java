package algorithms.solution1404;

public class Solution2 {
    public int numSteps(String s) {
        int op = 0;
        int carry = 0;
        for(int i = s.length() - 1;i<0;i--) {
            int val = s.charAt(i) - '0' + carry;
            if(val % 2 == 1) {
                op += 2;
                carry = 1;
            } else {
                op ++;
            }
        }
        return op + carry;
    }
}
