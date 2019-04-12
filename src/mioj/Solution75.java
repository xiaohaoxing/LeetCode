package mioj;

import java.util.Scanner;

public class Solution75 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            String[] nums = line.split(",");
            int size = nums.length;
            Person[] list = new Person[size];
            for (int i = 0; i < size; i++) {
                list[i] = new Person(Integer.parseInt(nums[i]));
            }
            int asignNum = 0;
            int currentNum = 1;
            // first round, find the lowest.
            for (int i = 0; i < size; i++) {
                if (isValley(list, i)) {
                    list[i].asign(currentNum);
                    asignNum++;
                }
            }
            while (asignNum < size) {

            }
        }
    }

    public static boolean isValley(Person[] list, int index) {
        int currentValue = list[index].flower;
        if (index == 0) {
            if (list[index + 1].flower >= currentValue) {
                return true;
            } else {
                return false;
            }
        }
        if (index == list.length - 1) {
            if (list[index - 1].flower > currentValue) {
                return true;
            } else {
                return false;
            }
        }
        if (list[index - 1].flower > currentValue && list[index + 1].flower > currentValue) {
            return true;
        } else {
            return false;
        }
    }

    public static void asign(Person[] list, int index) {

    }
}

class Person {
    int flower;
    int candy;
    boolean asigned;

    public Person(int flower) {
        this.flower = flower;
        candy = 0;
        asigned = false;
    }

    public void asign(int num) {
        asigned = true;
        this.candy = num;
    }
}