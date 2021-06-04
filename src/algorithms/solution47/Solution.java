package algorithms.solution47;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 肖皓星
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }
        TreeNode root = new TreeNode(0);
        next(root, counts);
        List<List<Integer>> result = new ArrayList<>();
        for (TreeNode node : root.children) {
            getPath(node, new ArrayList<>(), result);
        }
        return result;
    }

    public void getPath(TreeNode node, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(node.value);
        if (node.children == null) {
            result.add(currentPath);
            return;
        }
        for (TreeNode child : node.children) {
            List<Integer> childPath = new ArrayList<>(currentPath);
            getPath(child, childPath, result);
        }
    }

    public List<TreeNode> next(TreeNode current, HashMap<Integer, Integer> counts) {
        if (counts.isEmpty()) {
            return null;
        }
        List<TreeNode> nexts = new ArrayList<>(counts.size());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            TreeNode next = new TreeNode(num);
            HashMap<Integer, Integer> nextCount = new HashMap<>(counts);
            if (counts.get(num) == 1) {
                nextCount.remove(num);
            } else {
                nextCount.put(num, counts.get(num) - 1);
            }

            next.children = next(next, nextCount);
            nexts.add(next);
        }
        current.children = nexts;
        return nexts;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        int[] data = new int[]{1, 1, 2};
        test.permuteUnique(data);
    }

}

class TreeNode {
    List<TreeNode> children;

    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
