package algorithms.solution206;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode nex = head.next.next;
        head.next = null;
        while (nex != null) {
            // reverse links
            ListNode tmp = nex.next;
            nex.next = cur;
            cur.next = pre;
            // move forward
            pre = cur;
            cur = nex;
            nex = tmp;
        }
        if(cur.next!=pre) {
            cur.next = pre;
        }
        return cur;
    }
    
    public static void main(String[] args) {
        
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode result = new Solution().reverseList(node1);
        System.out.println(result);
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}