package algorithms.solution17;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * 9宫格键盘按了几个数字，求所有可能的字符组合。比较简单。
 */
class Solution {
    public static Dictionary<Integer, char[]> list = new Hashtable<>();

    static {
        list.put(2, new char[]{'a', 'b', 'c'});
        list.put(3, new char[]{'d', 'e', 'f'});
        list.put(4, new char[]{'g', 'h', 'i'});
        list.put(5, new char[]{'j', 'k', 'l'});
        list.put(6, new char[]{'m', 'n', 'o'});
        list.put(7, new char[]{'p', 'q', 'r', 's'});
        list.put(8, new char[]{'t', 'u', 'v'});
        list.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        for (char digit : digits.toCharArray()) {
            int num = digit - 48;
            result = append(result, list.get(num));

        }
        return result;
    }

    public static List<String> append(List<String> before, char[] letters) {
        List<String> result = new LinkedList<>();
        for (String last : before) {
            for (char letter : letters) {
                result.add(last + letter);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        List<String> result = test.letterCombinations("23");
        for (String token : result) {
            System.out.println(token);
        }
    }
}
