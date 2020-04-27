package algorithms.solution965;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        return isUnivalNode(root.left, value) && isUnivalNode(root.right, value);
    }
    
    public boolean isUnivalNode(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && isUnivalNode(node.left, val) && isUnivalNode(node.right, val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}
