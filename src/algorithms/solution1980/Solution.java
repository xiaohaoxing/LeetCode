
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Node root = new Node('2', null);
        for(int i = 0; i < nums.length; i ++) {
            Node current = root;
            for(int j = 0; j < nums[0].length(); j ++) {
                if(nums[i].charAt(j) == '0') {
                    if(current.left == null) {
                        current.left = new Node('0', current);
                    }
                    current = current.left;
                } else {
                    if(current.right == null) {
                        current.right = new Node('1', current);
                    }
                    current = current.right;
                }
            }

        }

        // tree build done
        List<Node> layer = new ArrayList<>();
        layer.add(root);
        for(int i = 0; i < nums[0].length(); i ++) {
            List<Node> nextLayer = new ArrayList<>();
            for(Node cur : layer) {
                if(cur.left == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('0');
                    for(int j = i + 1; j < nums[0].length(); j ++) {
                        sb.append('0');
                    }
                    while(cur.value!='2') {
                        sb.insert(0, cur.value);
                        cur = cur.parent;
                    }
                    return sb.toString();
                } else if(cur.right == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('1');
                    for(int j = i + 1; j < nums[0].length(); j ++) {
                        sb.append('0');
                    }
                    while(cur.value!='2') {
                        sb.insert(0, cur.value);
                        cur = cur.parent;
                    }
                    return sb.toString();
                } else {
                    nextLayer.add(cur.left);
                    nextLayer.add(cur.right);
                }
            }
            layer = nextLayer;
        }
        return "";
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        // String result = test.findDifferentBinaryString(new String[]{"00", "01"});
        String result = test.findDifferentBinaryString(new String[]{"111","011","001"});
        System.out.println(result);
    }
}

class Node {
    public char value;
    public Node left;
    public Node right; 
    public Node parent;
    public Node(char value, Node parent) {
        this.value = value;
        this.parent = parent;
    }
}