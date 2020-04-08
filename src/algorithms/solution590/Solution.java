package algorithms.solution590;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return postorderNode(root);
    }

    public List<Integer> postorderNode(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                result.addAll(postorderNode(child));
            }
        }
        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n3.children.add(n5);
        n3.children.add(n6);
        n1.children.add(n3);
        n1.children.add(n2);
        n1.children.add(n4);
        Solution test = new Solution();
        List<Integer> result = test.postorder(n1);
        System.out.println(result.size());
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node() {
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }
    
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
};