package algorithms.meeting2025;

public class MergeTwoOrderedLinkList {
    public ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (first != null && second != null) {
            if (first.value < second.value) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }
        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }
        return head.next;
    }

    static class ListNode {

        public ListNode next;
        int value;
    }

    public static void main(String[] args) {
        MergeTwoOrderedLinkList test = new MergeTwoOrderedLinkList();
        ListNode case1 = buildList(new int[]{1, 3, 5, 7, 9});
        ListNode case2 = buildList(new int[]{2, 4, 6, 8, 10});
        ListNode result = test.merge(case1, case2);
        print(result);
    }

    public static ListNode buildList(int[] list) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 0; i < list.length; i++) {
            ListNode newNode = new ListNode();
            newNode.value = list[i];
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("");
        }
        StringBuilder sb = new StringBuilder(head.value);
        ListNode current = head;
        while (current != null) {
            sb.append(",");
            sb.append(current.value);
            current = current.next;
        }
        System.out.println(sb.toString());
    }
}
