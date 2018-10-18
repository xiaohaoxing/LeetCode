package algorithms.solution22;

import java.util.LinkedList;
import java.util.List;

/**
 * 最终的实现，用 list 的更新去做。如果再进一步优化，可能就是 Leetcode 上的版本了。
 * Leetcode demo：
 * function calc(){
 * if(length = 2n){
 * add()
 * return
 * }
 * if(open<n){
 * calc(open+1)
 * }
 * if(close < open){
 * calc(close+1)
 * }
 * }
 */
public class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<Node> layer = new LinkedList();
        Node root = new Node(false);
        root.sum = 0;
        root.record = "";
        layer.add(root);
        List<String> result = new LinkedList<>();
        for (int i = 0; i < 2 * n; i++) {
            layer = generateLayer(layer);
        }
        for (Node node : layer) {
            if (node.sum == 0) {
                result.add(node.record);
            }
        }
        return result;
    }

    public static List<Node> generateLayer(List<Node> parents) {
        List<Node> result = new LinkedList<>();
        for (Node n : parents) {
            Node left = new Node(true);
            left.sum = n.sum + 1;
            left.record = n.record + "(";
            result.add(left);
            Node right = new Node(false);
            right.sum = n.sum - 1;
            right.record = n.record + ")";
            if (right.sum >= 0) {
                result.add(right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Node> root = new LinkedList();
        Node node = new Node(false);
        node.sum = 0;
        node.record = "";
        root.add(node);
        List<Node> layer1 = generateLayer(root);
        List<Node> layer2 = generateLayer(layer1);
        List<Node> layer3 = generateLayer(layer2);
        List<Node> layer4 = generateLayer(layer3);
        List<Node> layer5 = generateLayer(layer4);
        List<Node> layer6 = generateLayer(layer5);
        for (Node n : layer6) {
            if (n.sum == 0) {
                System.out.println(n);
            }
        }
    }
}

class Node {
    public boolean value;
    public int sum;
    public String record;

    public Node(boolean value) {
        this.value = value;
    }

    public String toString() {
        return this.record;
    }
}
