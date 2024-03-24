package algorithms.solution143;

import java.util.Stack;

public class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        ListNode left = head;
        ListNode right = stack.pop();
        while (true) {
            // backup
            ListNode nextLeft = left.next;
            // do right
            left.next = right;
            // do left
            if (nextLeft == null) {
                break;
            }
            right.next = nextLeft;

            if (right == nextLeft) {
                right.next = null;
                break;
            }
            right.next = nextLeft;
            right = stack.pop();

            left = nextLeft;
            if (left == right) {
                left.next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        printList(head);
        Solution test = new Solution();
        test.reorderList(head);
        printList(head);
    }

    public static ListNode buildList(int[] arr) {
        ListNode beforeHead = new ListNode();
        ListNode current = beforeHead;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        return beforeHead.next;
    }

    public static void printList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();
    }
}
