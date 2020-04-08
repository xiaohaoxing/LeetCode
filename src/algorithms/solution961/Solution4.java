package algorithms.solution961;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution4 {
    public int repeatedNTimes(int[] A) {
        int value = 0;
        int count = 0;
        for (int a:A) {
            if(value == a) {
                count ++;
            }else{
                if(count == 0) {
                    value = a;
                    count  = 1;
                }else{
                    count --;
                }
            }
        }
        return value;
    }
    public static void main(String[] args) {
        int[] test = {1,2,3,3};
        int result = new Solution4().repeatedNTimes(test);
        System.out.println(result);
    }
}
