package nowcoder.sort;

/**
 * @author 肖皓星
 */
public class Bubble extends BaseSort {
    @Override
    public int[] sort(int[] arr) {
        boolean swaped = true;
        while (swaped) {
            swaped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                    swaped = true;
                }
            }
        }
        return arr;
    }


}
