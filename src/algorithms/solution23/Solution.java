package algorithms.solution23;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 用优先级队列做很快。
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = new ListNode(0);
        boolean[] need = new boolean[lists.length];
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                need[i] = true;
            } else {
                need[i] = false;
            }
        }
        ListNode tail = head;
        while (checkNeed(need) > 1) {
            tail = mergeSomeLists(lists, need, tail);
        }
        for (int i = 0; i < lists.length; i++) {
            if (need[i]) {
                tail.next = lists[i];
            }
        }
        return head.next;
    }

    public static int checkNeed(boolean[] need) {
        int count = 0;
        for (boolean n : need) {
            if (n) count++;
        }
        return count;
    }

    public static ListNode mergeSomeLists(ListNode[] lists, boolean[] need, ListNode result) {
        // find first need list
        int minIndex = -1;
        for (int i = 0; i < need.length; i++) {
            if (need[i]) {
                minIndex = i;
            }
        }
        if (minIndex == -1) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            if (need[i]) {
                if (lists[i].val < lists[minIndex].val) {
                    minIndex = i;
                }
            }
        }
        result.next = new ListNode(lists[minIndex].val);
        if (lists[minIndex].next == null) {
            need[minIndex] = false;
        }
        lists[minIndex] = lists[minIndex].next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list1 = null;
        ListNode list2 = new ListNode(-1);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(11);
        ListNode list3 = null;
        ListNode list4 = new ListNode(6);
        list4.next = new ListNode(8);
        ListNode[] lists = new ListNode[]{list1, list2, list3, list4};
        Solution test = new Solution();
        test.mergeKLists(lists);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}