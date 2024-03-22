package algorithms.solution234;

import java.util.Stack;

/**
 * 更快的做法：
 * 快慢指针，快的到结尾，慢的到中间，再把前面一半的链表翻转再比对。
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        node = head;
        while (node != null) {
            int current = stack.pop();
            if (current != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2});
        Solution test = new Solution();
        boolean result = test.isPalindrome(head);
        System.out.println(result);
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
}


