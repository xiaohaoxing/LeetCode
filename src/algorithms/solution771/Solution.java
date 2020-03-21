package algorithms.solution771;

/**
 * 非递归方式
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J.isEmpty() || S.isEmpty()){
            return 0;
        }
        char[] stores = S.toCharArray();
        char[] jewels = J.toCharArray();
        int result = 0;
        for (int i = 0; i < stores.length; i++) {
            for (int j = 0; j < jewels.length; j++) {
                if(jewels[j] == stores[i]){
                    result ++;
                }
            }
        }
        return result;
    }
}