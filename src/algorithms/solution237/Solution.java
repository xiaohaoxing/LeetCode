package algorithms.solution237;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
}
