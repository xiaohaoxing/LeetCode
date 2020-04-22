package algorithms.solution922;

import algorithms.utils.ListPrinter;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int oddIdx = 1;
        int evenIdx = 0;
        while (true) {
            while (oddIdx <= A.length - 1 && A[oddIdx] % 2 == 1) {
                oddIdx += 2;
            }
            while (evenIdx <= A.length - 2 && A[evenIdx] % 2 == 0) {
                evenIdx += 2;
            }
            if (oddIdx > A.length - 1 && evenIdx > A.length - 2) {
                break;
            }
            int tmp = A[oddIdx];
            A[oddIdx] = A[evenIdx];
            A[evenIdx] = tmp;
            oddIdx += 2;
            evenIdx += 2;
        }
        return A;
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{3,4};
        int[] result = new Solution().sortArrayByParityII(test);
        ListPrinter.printArray(result);
    }
    
}
