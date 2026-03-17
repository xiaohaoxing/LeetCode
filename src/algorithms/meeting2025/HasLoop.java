package algorithms.meeting2025;

public class HasLoop {

    public boolean hasLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        public ListNode next;
        int value;
    }

    public static void main(String[] args) {
        HasLoop test = new HasLoop();
        ListNode case1 = buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        // 构建环
        ListNode tail = case1;
        while(tail.next != null) {
            tail = tail.next;
        }
        // tail.next = case1;
        boolean result1 = test.hasLoop(case1);
        System.out.println(result1);
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
