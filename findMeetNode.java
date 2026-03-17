

public class findMeetNode {
    class Node {
        int value;
        Node next;
    }
    public Node findMeetNode(Node a, Node b) {
        if(a == null || b == null) {
            return null;
        }
        int lengthA = 1;
        int lengthB = 1;
        Node headA = a;
        while(headA.next != null) {
            headA = headA.next;
            lengthA ++;
        }
        Node headB = b;
        while(headB.next != null) {
            headB= headB.next;
            lengthB ++;
        }
        if(headA != headB) {
            return null;
        }
        if(lengthA > lengthB) {
            for(int i = 0;i < (lengthA - lengthB); i++) {
                b = b.next;
            }
        } else if(lengthB > lengthA) {
            for(int i = 0;i < (lengthB - lengthA); i++) {
                a = a.next;
            }
        }
        while(a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
