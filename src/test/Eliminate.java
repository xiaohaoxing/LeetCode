package test;

public class Eliminate {

    public static String eliminate(String in) {
        int count_a = 0;
        StringBuilder result = new StringBuilder();
        for (char i : in.toCharArray()) {
            switch (i) {
                case 'a':
                    count_a++;
                    break;
                case 'b':
                    continue;
                case 'c':
                    if (count_a > 0) {
                        count_a--;
                    } else {
                        result.append('c');
                    }
                    break;
                default:
                    while (count_a > 0) {
                        result.append('a');
                        count_a--;
                    }
                    count_a = 0;
                    result.append(i);
            }
        }
        while (count_a > 0) {
            result.append('a');
            count_a--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String test = "aaabbcc";
        System.out.println(eliminate(test));

    }
}
