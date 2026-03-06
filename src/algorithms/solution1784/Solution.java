public class Solution{

    public boolean checkOnesSegment(String s) {
        boolean hasZero = false;
        for(int i = 1; i < s.length();i++) {
            if(s.charAt(i) == '0') {
                hasZero = true;
            } else if(hasZero) {
                return false;
            }
        }
        return true;
    }
}