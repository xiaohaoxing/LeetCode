package nowcoder.practice2;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * 这里需要注意 java 数字的 bug：10.4保存为10.3999999999996这样子。
 * 所以需要格式化一下double 数字。或者换个思路：全搞成整数
 * 而且还要注意全是0的要排除掉。
 */
public class Main {
    public static void main(String[] args) {
        HashSet<Double> values = new HashSet<Double>();
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 6; k++) {
                    double num = new Double(i * 0.8 + j * 1 + k * 1.8);
                    BigDecimal bnum = new BigDecimal(num);
                    num = bnum.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    values.add(num);
                }
            }
        }
        System.out.println(values.size() - 1);
    }

}