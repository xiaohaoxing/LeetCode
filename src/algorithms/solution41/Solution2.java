package algorithms.solution41;


public class Solution2 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        List list = new List();
        for(int num : nums) {
            list.insert(num);
        }
        Node2 current = list.head.next;
        if(current == null ||current.value > 1) {
            return 1;
        }else {
            int currentValue = current.value;
            while(current.next != null) {
                current = current.next;
                currentValue++;
                if(currentValue != current.value) {
                    return currentValue;
                }
            }
            return currentValue+1;
        }
    }

    public static void main(String[] args) {
        List list = new List();
    
        int[] nums = new int[]{1,2,2,1,3,1,0,4,0};
        Solution2 solution = new Solution2();
        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
        
    }
}

class Node2 {
    int value;
    Node2 next;
    public Node2(int value) {
        this.value = value;
    }
    public Node2() {

    }
}

class List {
    Node2 head;
    public List() {
        this.head = new Node2(0);
    }
    public void insert(int value) {
        // 负数不插入
        if (value <= 0 ){
            return;
        }
        Node2 temp = new Node2(value);
        // 插入首位
        if(head.next == null || value < head.next.value) {
            temp.next = head.next;
            head.next = temp;
            return;
        }
        // 其他情况
        Node2 current = head;
        while(current.next != null) {
            if(current.next.value == value) {return;}
            if(current.value < value && current.next.value > value) {
                temp.next = current.next;
                current.next = temp;
                return;
            }
            current = current.next;
        } 
        current.next = temp;
    }
    public void print() {
        Node2 current = head.next;
        System.out.print("[");
        while(current != null) {
            System.out.print(current.value + ",");
            current = current.next;
        }
        System.out.println("]");
    }
}
