package test;

import java.util.LinkedList;

public class LayerTrivers {


    public static BinNode triversing(int[] list) {
        if (list.length == 0) {
            return null;
        }
        BinNode root = new BinNode(list[0]);
        LinkedList<BinNode> queue = new LinkedList();
        queue.addLast(root);
        int index = 1;
        while (index < list.length) {
            BinNode parent = queue.pop();
            BinNode left, right;
            left = new BinNode(list[index++]);
            parent.left = left;
            if (index == list.length) {
                return root;
            } else {
                right = new BinNode(list[index++]);
                parent.right = right;
                if (left.value != -1) queue.addLast(left);
                if (right.value != -1) queue.addLast(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, -1, 2, 3};
        BinNode root = triversing(list);
        return;
    }
}

class BinNode {
    public BinNode(int value) {
        this.value = value;
    }

    int value;
    BinNode left;
    BinNode right;
}
