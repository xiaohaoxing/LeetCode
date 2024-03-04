package algorithms.solution948;

import java.util.Arrays;

/**
 * 排序，取2个指针，最大的条件是初始值+右边>左边，同时保证数量差最大。
 *
 * 我的方法用两层循环，更好的办法是贪心，先尝试吞大数，凑小数，不够的时候再吞一个大数继续做下去直到双指针相遇。
 * @author xiaohaoxing
 */
public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if(tokens.length == 0 || power < tokens[0]) {
            return 0;
        }
        int max = 0;
        int currentPower = power;
        // no face down?
        int p = 0;
        int s = 0;
        while (s < tokens.length && p + tokens[s] < power) {
            p += tokens[s];
            s += 1;
        }
        max = s;
        for (int j = tokens.length - 1; j > 0; j--) {
            int score = j - tokens.length;
            int cost = 0;
            currentPower += tokens[j];
            for (int i = 0; i < j && cost + tokens[i] <= currentPower; i++) {
                score += 1;
                cost += tokens[i];
            }
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] tokens = new int[]{26};
        int power =51;
        Solution test = new Solution();
        int result = test.bagOfTokensScore(tokens, power);
        System.out.println(result);
    }

}
