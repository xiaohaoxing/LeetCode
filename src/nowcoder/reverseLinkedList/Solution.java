package nowcoder.reverseLinkedList;

/**
 * @author 肖皓星
 */

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        int length = 0;
        while (current != null) {
            current = current.next;
            length += 1;
        }
        ListNode[] arr = new ListNode[length];
        current = head;
        for (int i = 0; i < length; i++) {
            arr[i] = current;
            current = current.next;
        }
        for (int i = length - 1; i > 0; i--) {
            arr[i].next = arr[i - 1];
        }
        arr[0].next = null;
        return arr[length - 1];
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        printLinkedList(a);
        Solution test = new Solution();
        ListNode result = test.ReverseList2(a);
        printLinkedList(result);
    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            // 空链表
            return null;
        }
        ListNode a = head;
        ListNode b = a.next;
        if (b == null) {
            // 1 个元素
            return head;
        }
        ListNode tailHead = b.next;
        if (tailHead == null) {
            // 2 个元素
            b.next = a;
            return b;
        }
        a.next = null;
        while (tailHead != null) {
            b.next = a;
            a = b;
            b = tailHead;
            tailHead = tailHead.next;
        }
        b.next = a;
        return b;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        System.out.print(head.val);
        current = current.next;
        while (current != null) {
            System.out.print("->" + current.val);
            current = current.next;
        }
        System.out.println();
    }
}