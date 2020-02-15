package algorithms.solution43;

/**
 * 48 = '0'
 *
 * @author 肖皓星
 * @email xiaohaoxing@xiaomi.com
 * @date 2020/2/15 22:22
 */
public class Solution {
    public int base = 48;

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int length = num1.length() + num2.length();
        char[] result = zeroChars(length);
        int pos = num2.length() - 1;
        for (int i = num2.length() - 1; i >= 0; i--) {
            result = merge(result, multiplySingle(num1, num2.charAt(i), length, pos));
            pos--;
        }
        String str = String.valueOf(result);
        return result[0] == base ? str.substring(1) : str;
    }

    /**
     * 合并2个相同长度的数字数组
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public char[] merge(char[] arr1, char[] arr2) {
        char[] result = new char[arr1.length];
        boolean isUpgrade = false;
        for (int i = arr1.length - 1; i >= 0; i--) {
            int current = arr1[i] + arr2[i] - base;
            current += isUpgrade ? 1 : 0;
            if (current > 9 + base) {
                isUpgrade = true;
                result[i] = (char) (current - 10);
            } else {
                isUpgrade = false;
                result[i] = (char) current;
            }
        }
        return result;
    }

    public char[] multiplySingle(String num, char n, int length, int frm) {
        int upgrade = 0;
        char[] result = zeroChars(length);
        if (n == base) {
            return result;
        }
        for (int i = num.length() - 1; i >= 0; i--) {
            int current = atomicMultiply(num.charAt(i), n);
            current += upgrade;
            result[i + frm + 1] = (char) (current % 10 + base);
            upgrade = current / 10;
        }
        result[frm] = (char) (upgrade + base);
        return result;
    }

    private int atomicMultiply(char pos1, char pos2) {
        return (pos1 - base) * (pos2 - base);
    }

    public char[] zeroChars(int length) {
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = (char) base;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        char[] result1 = test.multiplySingle("999", '9', 10, 2);
//        char[] result2 = test.multiplySingle("999", '9', 10, 1);
//        char[] result = test.merge(result1, result2);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        String result = test.multiply("9", "99");
        System.out.println(result);
    }
}
