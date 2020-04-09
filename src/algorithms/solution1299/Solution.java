package algorithms.solution1299;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current =arr[i];
            arr[i] = max;
            if(current > max) {
                max = current;
            }
        }
        return arr;
    }
}
