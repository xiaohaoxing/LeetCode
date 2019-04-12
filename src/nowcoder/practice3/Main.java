package nowcoder.practice3;

public class Main {
    public static void main(String[] args) {
        for (int i = 1000; i <= 1111; i++) {
            if (ok(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean ok(int i) {
        if (i == 1089) {
            int k = 0;
        }
        int nineTimes = i * 9;
        char[] chars = (i + "").toCharArray();

        String backwards = "" + chars[3] + chars[2] + chars[1] + chars[0];
        if (backwards.equals("" + nineTimes)) {
            return true;
        } else {
            return false;
        }
    }
}
