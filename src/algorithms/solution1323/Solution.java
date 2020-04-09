package algorithms.solution1323;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int maximum69Number(int num) {
        String numStr=String.valueOf(num);
        int index = numStr.indexOf('6');
        if(index == -1){
            return num;
        }
        return Integer.valueOf(numStr.replaceFirst("[6]", "9"));
    }
}
