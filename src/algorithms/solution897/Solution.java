package algorithms.solution897;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    TreeNode fake = new TreeNode(-1);
    TreeNode current = fake;
    
    public TreeNode increasingBST(TreeNode root) {
        sort(root);
        return fake.right;
    }
    
    public void sort(TreeNode root) {
        if (root == null) {
            return;
        }
        sort(root.left);
        current.right = new TreeNode(root.val);
        current = current.right;
        sort(root.right);
    }
    
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n5.left = n3;
        n5.right = n6;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n6.right = n8;
        n8.left = n7;
        n8.right = n9;
        TreeNode root = new Solution().increasingBST(n5);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
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
