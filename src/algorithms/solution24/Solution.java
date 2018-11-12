package algorithms.solution24;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private static ListNode node1;
    private static ListNode node2;
    private static ListNode node3;

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode current = prehead;
        while (current.next != null && current.next.next != null) {
            swapPair(current);
            current = current.next.next;
        }
        return prehead.next;
    }

    // pre->node1->node2->node3
    // trans:
    // pre->node2->node1->node3
    public static void swapPair(ListNode pre) {
        node1 = pre.next;// store node1
        node2 = node1.next;// store node2
        node3 = node2.next;// store node3
        node1.next = node3;
        node2.next = node1;
        pre.next = node2;
    }


    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        printList(node1);
        Solution test = new Solution();
        ListNode result = test.swapPairs(node1);
        printList(result);
//        Solution test = new Solution();
//        ListNode node0 = new ListNode(0);
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        node0.next = node1;
//        node1.next = node2;
//        printList(node0);
//        swapPair(node0);
//        printList(node0);
    }
}