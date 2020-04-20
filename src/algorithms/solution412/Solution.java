package algorithms.solution412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n ; i++) {
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;
            if(fizz && buzz) {
                result.add("FizzBuzz");
            }else if(fizz) {
                result.add("Fizz");
            }else if(buzz) {
                result.add("Buzz");
            }else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
