package algorithms.meeting2025.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    public Node root;

    public Tree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        this.root = one;
    }

    // 非递归前序遍历
    public void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        if (root != null) {
            stack.push(root);
        }
        while (stack.size() > 0) {
            Node current = stack.pop();
            System.out.println(current.value);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // 递归前序遍历
    public void preOrderTraversalRecursive(Node root) {
        if (root != null) {
            System.out.println(root.value);
        }
        if (root.left != null) {
            preOrderTraversal((root.left));
        }
        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

    // 非递归中序遍历
    public void midOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node head = root;
        while (stack.size() > 0 || head != null) {
            if (head != null) {
                stack.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            } else {
                Node current = stack.pop();
                System.out.println(current.value);
                head = current.right;
            }
        }
    }

    // 递归中序遍历
    public void midOrderTraversalRecursive(Node root) {
        if (root != null) {
            midOrderTraversalRecursive(root.left);
            System.out.println(root.value);
            midOrderTraversalRecursive(root.right);
        }
    }

    // 非递归后序遍历
    public void postOrderTravelsal(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node head = root;
        Node last = null;
        while (stack.size() > 0 || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            if (head.right == null || head.right == last) {
                System.out.println(head.value);
                last = head;
                head = null;
            } else {
                stack.push(head);
                head = head.right;
            }
        }
    }

    // 递归后序遍历
    public void postOrderTravelsalRecursive(Node root) {
        if (root != null) {
            postOrderTravelsalRecursive(root.left);
            postOrderTravelsalRecursive(root.right);
            System.out.println(root.value);
        }
    }

    public void layerOrderTravelsal(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size() > 0) {
            Node current = queue.poll();
            System.out.println(current.value);
            if(current.left != null) {
                queue.add(current.left);
            } 
            if(current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void layerOrderTravelsalRecursive(Node root) {
        Node[] layer = new Node[]{root};
        while(layer.length > 0) {
            layer = layerOrderTravelsalRecursiveLayer(layer);
        }
    }

    public Node[] layerOrderTravelsalRecursiveLayer(Node[] roots) {
        boolean hasNext = false;
        Node[] newLayer = new Node[roots.length * 2];
        for (int i = 0; i < roots.length; i++) {
            Node node = roots[i];
            if (node != null) {
                hasNext = true;
                System.out.println(node.value);
                newLayer[i * 2] = node.left;
                newLayer[i * 2 + 1] = node.right;
            }
        }
        if(hasNext) {
            return newLayer;
        } else {
            return new Node[0];
        }
    }

    public static void main(String[] args) {
        Tree test = new Tree();
        // test.preOrderTraversal(test.root);
        // test.midOrderTraversal(test.root);
        // test.postOrderTravelsal(test.root);
        test.layerOrderTravelsal(test.root);
    }
}

class Node {
    public Node left;
    public int value;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}