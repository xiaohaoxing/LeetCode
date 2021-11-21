package algorithms.solution10;

import java.util.HashMap;
import java.util.Map;

class Node {
    char element;
    boolean repeatable;
    Node next;

    public Node(char element) {
        this.element = element;
        this.repeatable = false;
    }

    public void repeatable() {
        this.repeatable = true;
    }

    @Override
    public String toString() {
        return element + (repeatable ? "*" : "");
    }
}

public class Solution4 {
    char START = '^';
    char ANY = '.';

    public boolean isMatch(String s, String p) {
        Node node = buildList(p);
        return isMatch(s.toCharArray(), 0, node);
    }

    // 尾部的***都要想办法匹配上
    public boolean isMatch(char[] target, int targetIndex, Node node) {
        if (targetIndex == target.length && (node == null || (node.repeatable && isMatch(target, targetIndex, node.next)))) {
            return true;
        }
        if (targetIndex >= target.length || node == null) {
            return false;
        }
        if (node.repeatable) {
            return isMatch(target, targetIndex, node.next) ||
                    (isMatch(target[targetIndex], node) && isMatch(target, targetIndex + 1, node));
        } else {
            return isMatch(target[targetIndex], node) && isMatch(target, targetIndex + 1, node.next);
        }
    }

    private boolean isMatch(char c, Node node) {
        return node.element == ANY || node.element == c;
    }

    public Node buildList(String p) {
        char[] chars = p.toCharArray();
        Node head = new Node(START);
        Node current = head;
        for (char c : chars) {
            if (c == '*') {
                current.repeatable();
                continue;
            }
            Node next = new Node(c);
            current.next = next;
            current = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        HashMap<String, String> cases = new HashMap<>();
        cases.put("aa", "a*");
        cases.put("ab", "c*a*b");
        cases.put("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*");
        Solution4 test = new Solution4();
        for (Map.Entry<String, String> entry : cases.entrySet()) {
            System.out.println(entry.getKey() + ".matches(" + entry.getValue() + ") = " + test.isMatch(entry.getKey(), entry.getValue()));
        }
    }
}
