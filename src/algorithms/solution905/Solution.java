package algorithms.solution905;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        boolean swap = false;
        int temp;
        for (int i = 0; i < A.length; i++) {
            if(A[i]%2 == 1) {
                swap = false;
                for (int j = i + 1; j < A.length; j++) {
                    if(A[j] %2 == 0) {
                        temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        swap = true;
                        break;
                    }
                }
                if(!swap){
                    return A;
                }
            }
        }
        return A;
    }
}
