package algorithms.solution965;

import java.util.Stack;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution2 {
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int value = root.val;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.val != value){
                return false;
            }
            if(node.left!=null) {
                stack.push(node.left);
            }
            if(node.right!=null) {
                stack.push(node.right);
            }
        }
        return true;
    }
}
