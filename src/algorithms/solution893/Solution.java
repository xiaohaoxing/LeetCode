package algorithms.solution893;

import java.util.Arrays;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        return 0;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Chary");
        String result = names.stream().reduce("", (a, b) -> a.isEmpty() ? b : a + "," + b);
        System.out.println(result);
    }
}
