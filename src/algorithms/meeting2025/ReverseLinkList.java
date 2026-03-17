package algorithms.meeting2025;

public class ReverseLinkList {
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    static class ListNode {
        public ListNode next;
        int value;
    }


    public static void main(String[] args) {
        ReverseLinkList test = new ReverseLinkList();
        ListNode case1 = buildList(new int[]{1,2});
        print(case1);
        ListNode result1 = test.reverse(case1);
        print(result1);
    }

    public static ListNode buildList(int[] list) {
        ListNode head = new ListNode();
        ListNode current = head;
        for(int i = 0;i< list.length;i++) {
            ListNode newNode = new ListNode();
            newNode.value = list[i];
            current.next = newNode;
            current = newNode;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        if(head == null) {
            System.out.println("");
        }
        StringBuilder sb = new StringBuilder(head.value);
        ListNode current = head;
        while(current != null) {
            sb.append(",");
            sb.append(current.value);
            current = current.next;
        }
        System.out.println(sb.toString());
    }
}
