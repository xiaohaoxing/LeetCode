package algorithms.solution938;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        return (root.val >= L && root.val <= R ? root.val : 0) + (root.left == null ? 0 : rangeSumBST(root.left, L, R)) + (root.right == null ? 0 : rangeSumBST(root.right, L, R));
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


