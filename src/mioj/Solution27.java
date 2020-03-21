package mioj;

import java.util.*;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution27 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            Integer amount = Integer.parseInt(line);
            String weightStr = scan.nextLine().trim();
            String valueStr = scan.nextLine().trim();
            String[] weightStrs = weightStr.split(" ");
            String[] valueStrs = valueStr.split(" ");
            int[] weights = new int[weightStrs.length];
            int[] values = new int[valueStrs.length];
            for (int i = 0; i < weights.length; i++) {
                weights[i] = Integer.parseInt(weightStrs[i]);
                values[i] = Integer.parseInt(valueStrs[i]);
            }
            int result = maximumValue(amount, weights, values);
            System.out.println(result);
        }
    }

    public static int maximumValue(int amount, int[] weights, int[] values) {
        int value = 0;
        for (int i = 0; i < weights.length; i++) {
            value = Math.max(value, maximumValue(weights, values, i, amount, 0));
        }
        return value;
    }

    public static int maximumValue(int[] weights, int[] values, int fromIdx, int amountLeft, int currentValue) {
        System.out.println(String.format("当前在%d位置，剩余可带重量%d，当前价值%d", fromIdx, amountLeft, currentValue));
        int value = currentValue;
        for (int i = fromIdx; i < weights.length; i++) {
            if (weights[i] < amountLeft) {
                System.out.println(String.format("尝试带上%d位置石头，重%d，价值%d", i, weights[i], values[i]));
                value = Math.max(value, maximumValue(weights, values, i + 1, amountLeft - weights[i], currentValue + values[i]));
            }
        }
        return value;
    }

}
