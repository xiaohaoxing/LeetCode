package algorithms.solution104;

import java.util.ArrayList;

/**
 * 采用非递归的方式实现会出现WA。很奇怪
 *
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        ArrayList<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        depth = 1;
        while (true) {
            layer = nextLayer(layer);
            if (layer.size() == 0) {
                return depth;
            }
            depth++;
        }
    }

    public ArrayList<TreeNode> nextLayer(ArrayList<TreeNode> layer) {
        ArrayList<TreeNode> next = new ArrayList<>();
        boolean hasValue = false;
        for (int i = 0; i < layer.size(); i++) {
            TreeNode node = layer.get(i);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
        }
        return next;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(n3));

    }
}
