package algorithms.solution559;

import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 1;
        int maxChild = 0;
        for(Node child:root.children) {
            int currentDepth = maxDepth(child);
            if(currentDepth > maxChild) {
                maxChild = currentDepth;
            }
        }
        return depth + maxChild;
    }
}

class Node {
    public int val;
    public List<Node> children;
    
    public Node() {
    }
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
