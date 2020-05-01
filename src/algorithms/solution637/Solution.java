package algorithms.solution637;

import algorithms.utils.ListPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> layer = new ArrayList<>();
        ArrayList<Double> result = new ArrayList<>();
        double layerValue;
        int layerCount;
        layer.add(root);
        boolean hasNext = true;
        while (hasNext) {
            layerValue = 0;
            layerCount = 0;
            hasNext = false;
            ArrayList<TreeNode> newLayer = new ArrayList<>();
            for (TreeNode n : layer) {
                layerValue += n.val;
                layerCount += 1;
                if (n.left != null) {
                    hasNext = true;
                    newLayer.add(n.left);
                }
                if (n.right != null) {
                    hasNext = true;
                    newLayer.add(n.right);
                }
            }
            result.add(layerValue * 1.0 / layerCount);
            layer = newLayer;
        }
        return result;
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
        List<Double> result = new Solution().averageOfLevels(n3);
        ListPrinter.printList(result);
        
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