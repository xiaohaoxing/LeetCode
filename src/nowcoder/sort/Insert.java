package nowcoder.sort;

import algorithms.utils.ListPrinter;

/**
 * @author 肖皓星
 */
public class Insert extends BaseSort {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            ListPrinter.printArray(arr);
            int current = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > current) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = current;
        }
        return arr;
    }
}
