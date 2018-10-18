package algorithms.solution21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 链接的时候要把后面的节点给留下，不然断了就找不到了。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        ListNode current;
        ListNode x1 = l1;
        ListNode x2 = l2;
        if (l1.val < l2.val) {
            head = l1;
        } else {
            head = l2;
        }
        current = new ListNode(head.val);
        head = current;
        while (x1 != null && x2 != null) {
            if (x1.val < x2.val) {
                current.next = new ListNode(x1.val);
                current = current.next;
                x1 = x1.next;
            } else {
                current.next = new ListNode(x2.val);
                current = current.next;
                x2 = x2.next;
            }
        }
        if (x1 != null) {
            current.next = x1;
        } else if (x2 != null) {
            current.next = x2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution test = new Solution();
        ListNode result = test.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}


class ListNode {
    ListNode(int x) {
        val = x;
    }

    int val;
    ListNode next;

}