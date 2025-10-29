import java.lang.Math;

public class Solution {
    public int smallestNumber(int n) {
        int current = 1;
        while(current <= n) {
            current *= 2;
        }
        return Math.max(current - 1, 1);
    }
    
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.smallestNumber(10));
    }
}