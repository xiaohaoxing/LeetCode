package algorithms.solution589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return preorder(root, result);
    }

    public List<Integer> preorder(Node root, List<Integer> result) {
        result.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, result);
            }
        }
        return result;
    }
}
