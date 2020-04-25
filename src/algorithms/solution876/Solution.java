package algorithms.solution876;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next.next;
            mid = mid.next;
        }
        return mid;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}
