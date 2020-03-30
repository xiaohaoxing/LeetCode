package algorithms.solution728;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSelfDividingNumber(int i) {
        char[] digits = String.valueOf(i).toCharArray();
        for (char c : digits) {
            if (c == '0' || i % (c - '0') != 0) {
                return false;
            }
        }
        return true;
    }
}
