package algorithms.solution41;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private Node ll = new Node(0);
    private boolean startShorten;
    public int firstMissingPositive(int[] nums) {
        for(int i :nums) {
            insert(i);
        }
        Node current = ll.next;
        int last = current.value;
        while(current.next != null) {
            current = current.next;
            if(current.value == last+1){
                last++;
            }else{
                return last + 1;
            }
        }
        return current.value + 1;
    }

    public void insert(int value) {
        if(value < 1){
            return;
        }
        Node current = ll.next;
        if(current == null){
            ll.next = new Node(value);
            return;
        }
        if(startShorten) {
            int last = current.value;
            while (current.next != null) {
                current = current.next;
                if (current.value == last + 1) {
                    ll.next = current;
                    last++;
                } else {
                    break;
                }
            }
        }
        if(value == 1){
            startShorten = true;
        }
        current = ll.next;
        if(value < current.value){
            Node newNode = new Node(value);
            newNode.next = current;
            ll.next = newNode;
            return;
        }
        while(current.next!= null) {
            if(value > current.value && value < current.next.value){
                Node newNode = new Node(value);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
        }
        if(value > current.value) {
            current.next = new Node(value);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {3,4,-1,1};
        Solution test = new Solution();
        int result = test.firstMissingPositive(input);
        System.out.println(result);
    }
}

class Node{
    public Node(int value) {
        this.value = value;
    }
    public int value;
    public Node next;
}
