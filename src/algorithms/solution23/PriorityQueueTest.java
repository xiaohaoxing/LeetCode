package algorithms.solution23;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    private static PriorityQueue<Integer> sorter = new PriorityQueue<>((i1, i2) -> i1 > i2 ? 1 : -1);

    public static void main(String[] args) {
        System.out.println("排序前：");
        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 100);
            System.out.print(num + ",");
            sorter.add(num);
        }
        System.out.println();
        int[] result = new int[100];
        int index = 0;
        while (!sorter.isEmpty()) {
            int top = sorter.poll();
            result[index] = top;
            index++;
        }
        System.out.println("排序后：");
        for (int i : result) {
            System.out.print(i + ",");
        }
    }
}
