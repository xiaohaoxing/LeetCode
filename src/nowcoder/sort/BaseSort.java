package nowcoder.sort;

import algorithms.utils.ListPrinter;

/**
 * @author 肖皓星
 */
public abstract class BaseSort {
    public int[] sort(int[] arr) {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 6, 9, 8, 5, 1};
//        BaseSort test = new Bubble();
//        BaseSort test = new Insert();
        BaseSort test = new Select();
        int[] result = test.sort(data);
        ListPrinter.printArray(result);
    }
}
