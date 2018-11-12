package algorithms.solution23;

import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val < o2.val ? 1 : -1);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode out = queue.poll();
            tail.next = out;
            tail = tail.next;
            if (out.next != null) {
                queue.add(out.next);
            }
        }
        return head.next;
    }
}
