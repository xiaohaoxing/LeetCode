package algorithms.solution25;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode current = prehead;
        while (hasNextN(current, k)) {
            current = reverseNextN(current, k);
        }
        return prehead.next;
    }

    public static boolean hasNextN(ListNode pre, int n) {
        int count = 0;
        ListNode current = pre;
        while (count < n && current.next != null) {
            current = current.next;
            count++;
        }
        if (count == n) {
            return true;
        } else {
            return false;
        }
    }

    public static ListNode reverseNextN(ListNode pre, int n) {
        ListNode[] nodes = new ListNode[n];
        ListNode current = pre;
        int index = 0;
        for (; index < n; index++) {
            nodes[index] = current.next;
            current = current.next;
        }
        index--;
        nodes[0].next = nodes[n - 1].next;
        for (; index > 0; index--) {
            nodes[index].next = nodes[index - 1];
        }
        pre.next = nodes[n - 1];
        return nodes[0];
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
        ListNode result = test.reverseKGroup(node1, 4);
        printList(result);
    }

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[List: ");
        ListNode current = head;
        while (current.next != null) {
            sb.append(current + ", ");
            current = current.next;
        }
        sb.append(current + "]");
        System.out.println(sb.toString());
    }
}