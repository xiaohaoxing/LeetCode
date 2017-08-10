package algorithms;

/**
 * Created by Lenovo on 16.10.7.
 */
public class Solution19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //n+1个长度的队列
        ListNode from = head;
        ListNode to = head;
        for (int i = 0; i < n; i++) {
            //长度不到n
            if (to.next == null) {
                return null;
            }
            to = to.next;
        }
        to = to.next;
        while (to.next != null) {
            from = from.next;
            to = to.next;
        }
        from.next = from.next.next;
        return head;
    }
}

class ListNode {
    private int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

