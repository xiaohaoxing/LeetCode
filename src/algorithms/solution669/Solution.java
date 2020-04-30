package algorithms.solution669;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trimNode(root, L, R);
    }
    
    public TreeNode trimNode(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimNode(root.right, L, R);
        }
        if (root.val > R) {
            return trimNode(root.left, L, R);
        }
        // between
        root.left  = trimNode(root.left, L, R);
        root.right = trimNode(root.right, L, R);
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n0;
        n1.right = n2;
        TreeNode result = new Solution().trimBST(n1, 1, 2);
        System.out.println(result.val);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}