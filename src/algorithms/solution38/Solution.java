package algorithms.solution38;

public class Solution {
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.countAndSay(9));
    }

    public String countAndSay(int n) {
        return "" + count(n);
    }

    public static String count(int n) {
//        switch (n) {
//            case 1:
//                return "1";
//            case 2:
//                return "11";
//            case 3:
//                return "21";
//            case 4:
//                return "1211";
//            case 5:
//                return "111221";
//            default:
//        }
        if (n == 1) {
            return "1";
        }
        String before = count(n - 1);
        // get exp from the before
        char[] list = before.toCharArray();
        char current = list[0];
        char last = list[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            current = list[i];
            if (last == current) {
                count++;
            } else {
                result.append(count);
                result.append(last);
                count = 1;
                last = current;
            }

        }
        result.append(count);
        result.append(current);
        return result.toString();
    }
}

class Counter {
    char key;
    int count;

    Counter(char v) {
        key = v;
        count = 1;
    }
}
