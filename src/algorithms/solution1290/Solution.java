package algorithms.solution1290;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head !=null) {
            result *= 2;
            if(head.val == 1) {
                result += 1;
            }
            head = head.next;
        }
        return result;
    }
}
