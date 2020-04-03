package algorithms.solution905;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int temp;
        while (left < right) {
            while (A[left] % 2 == 0 && left < right) {
                left++;
            }
            while (A[right] % 2 == 1 && left < right) {
                right--;
            }
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left ++;
            right --;
        }
        return A;
    }
}
