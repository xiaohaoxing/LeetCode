package test;

class Node {
    int value;
    public Node next;

    public Node(int val) {
        this.value = val;
    }
}

public class Didi {
    public Node reverseByCount(Node head, int count) {
        Node currentNode = new Node(0);
        Node finalPre = currentNode;
        currentNode.next = head;
        while (currentNode != null) {
            int currentCount = 0;
            Node pre = currentNode;
            while (currentCount < count && currentNode != null) {
                currentNode = currentNode.next;
                currentCount += 1;
            }
            if(currentNode == null) {
                break;
            }
            System.out.println("swap " + pre.value + " between " + currentNode.value);
            Node first = pre.next;
            pre.next = null;
            Node post = currentNode.next;
            currentNode.next = null;
            reversePart(first);

            pre.next = currentNode;
            first.next = post;
            Didi.print(finalPre);
            currentNode = first;
        }
        return finalPre.next;
    }

    public void reversePart(Node head) {
        Node cur = head;
        while (cur.next != null) {
            Node right = cur.next;
            Node left = cur;
            left.next = right.next;
            right.next = left;
        }
    }

    public static void main(String[] args) {
        Node list = Didi.buildLink(new int[] { 1, 2, 3, 4, 5, 6 });
        Didi test = new Didi();
        test.reverseByCount(list, 3);
    }

    public static Node buildLink(int[] arr) {
        Node pre = new Node(0);
        Node head = pre;
        for (int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            pre.next = n;
            pre = n;
        }
        return head.next;
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.print(n.value + "->");
            n = n.next;
        }
        System.out.println();
    }
}