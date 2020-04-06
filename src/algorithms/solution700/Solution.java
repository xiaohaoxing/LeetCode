package algorithms.solution700;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}
