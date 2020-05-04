package algorithms.solution872;

import java.util.*;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> leaf1 = new LinkedList<>();
        LinkedList<Integer> leaf2 = new LinkedList<>();
        findLeaf(root1, leaf1);
        findLeaf(root2, leaf2);
        Iterator<Integer> i1 = leaf1.iterator();
        Iterator<Integer> i2 = leaf2.iterator();
        while(i1.hasNext() && i2.hasNext()) {
            if(!i1.next().equals(i2.next())) {
                return false;
            }
        }
        if(i1.hasNext() || i2.hasNext()) {
            return false;
        }
        return true;
    }
    public void findLeaf(TreeNode root, LinkedList leaves) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        findLeaf(root.left, leaves);
        findLeaf(root.right, leaves);
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
