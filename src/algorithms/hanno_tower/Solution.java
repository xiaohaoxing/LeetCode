package algorithms.hanno_tower;

import java.util.Stack;

/**
 * 给定4个参数。第一个是个数。后三个是柱子的编号。
 * 输出每一步移动的过程：
 * e.p.:
 * a->1->b
 * 即把1号盘子从 a 柱子移动到 b 柱子。
 */
public class Solution {
    public static void main(String[] args) {
        if (args.length != 4) {
            return;
        }
        int num = Integer.parseInt(args[0]);
        Pillar[] pillars = new Pillar[3];
        pillars[0] = new Pillar(args[1].charAt(0));
        pillars[1] = new Pillar(args[2].charAt(0));
        pillars[2] = new Pillar(args[3].charAt(0));
        pillars[0].init(num);
        Pillar.move(num, pillars[0], pillars[2], pillars[1]);
    }

    /**
     * 将编号为 dish 的碟子从 index 为 from 的柱子移动到 index 为 to 的柱子
     *
     * @param dish
     * @param names
     * @param from
     * @param to
     */
    public static void printMove(int dish, char[] names, int from, int to) {
        System.out.println(names[from] + "->" + dish + "->" + names[to]);
    }
}


class Pillar {
    Stack<Integer> dishes;
    char name;

    private Pillar() {
    }

    public Pillar(char name) {
        dishes = new Stack<>();
        this.name = name;
    }

    public void init(int count) {
        for (int i = count - 1; i >= 0; i--) {
            dishes.push(i);
        }
    }

    public int pop() {
        return this.dishes.pop();
    }

    public void push(int value) {
        this.dishes.push(value);
    }


    public static void move(int count, Pillar from, Pillar to, Pillar by) {
        if (count == 1) {
            int value = from.pop();
            System.out.println(from.name + "->" + value + "->" + to.name);
            to.push(value);
        } else {
            move(count - 1, from, by, to);
            move(1, from, to, by);
            move(count - 1, by, to, from);
        }
    }
}