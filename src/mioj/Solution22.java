package mioj;

import java.util.Scanner;

public class Solution22 {

    public static void main(String args[]) {
//        int ans = getDivision("1224".toCharArray(), 12);
//        System.out.println(ans);
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int Bigreminder = getDivision(line.toCharArray(), 128);
            double num = Math.sqrt(Bigreminder);
            num = Math.ceil(num - 1 / 32);
            int n = (int) num;

            int preBigSize = 8 * n * (16 * n + 1);
            System.out.println(preBigSize);
//            int reminder =
            // System.out.println("answer");
        }
    }

    public static int getReminder(char[] devider, int devidee) {
        int current = 0;
        for (char c : devider) {
            current = current * 10 + (c - 48);
            if (current >= devidee) {
                current = current % devidee;
            }

        }
        return current;
    }

    public static int getDivision(char[] devider, int devidee) {
        int ans = 0;
        int current = 0;
        for (char c : devider) {
            current = current * 10 + (c - 48);
            ans *= 10;
            if (current >= devidee) {
                ans += current / devidee;
                current = current % devidee;
            }

        }
        return ans;
    }
}
