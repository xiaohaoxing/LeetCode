package algorithms.solution1669;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2tail = list2;
        while (list2tail.next != null) {
            list2tail = list2tail.next;
        }

        ListNode current = list1;
        for (int i = 0; i < a - 1; i++) {
            current = current.next;
        }
        ListNode tmp = current.next;
        current.next = list2;
        current = tmp;
        for (int i = a; i <= b; i++) {
            current = current.next;
        }
        list2tail.next = current;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = buildList(new int[]{0, 1, 2, 3, 4, 5, 6});
        ListNode list2 = buildList(new int[]{1000000, 1000001, 1000002, 1000003, 1000004});
        printList(list1);
        printList(list2);
        Solution test = new Solution();
        ListNode result = test.mergeInBetween(list1, 2, 5, list2);
        printList(result);
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


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}