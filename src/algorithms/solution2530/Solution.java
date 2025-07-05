package algorithms.solution2530;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public long maxKelements(int[] nums, int k) {
        Arrays.sort(nums);
        Node head = new Node(-1);
        Node current = head;
        for (int i = nums.length - 1; i >= 0; i--) {
            current.next = new Node(nums[i]);
            current = current.next;
        }
        System.out.println(head.next);
        long result = 0L;
        while (k > 0) {
            int max = head.next.value;
            result += max;
            int newValue = (max + 2) / 3;
            current = head.next;
            while (current.next != null) {
                if (current.next.next != null && current.next.next.value < newValue) {
                    // newValue 插在 current 后面
                    Node newNode = new Node(newValue);
                    newNode.next = current.next.next;
                    current.next.next = newNode;
                    break;
                }
                current = current.next;
            }
            if (current.next == null) {
                current.next = new Node(newValue);
            }
            head.next = head.next.next;
            k -= 1;
            System.out.println(head.next);
        }
        return result;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(value);
            Node next = this.next;
            while (next != null) {
                sb.append(",");
                sb.append(next.value);
                next = next.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {10,10,10,10,10};
        System.out.println(solution.maxKelements(test, 5));
    }

}
