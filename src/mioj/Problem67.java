package mioj;

public class Problem67 {
    static class RoundNode {
        RoundNode(int i) {
            number = i;
        }

        public RoundNode(int i, RoundNode next) {
            number = i;
            this.next = next;
        }

        public int number;
        public RoundNode next;
    }

    //生成环形队列
    public static String solution(String line) {
        int target = Integer.parseInt(line);
        RoundNode head = new RoundNode(1);
        RoundNode temp = head;
        for (int i = 500; i > 1; i--) {
            RoundNode node = new RoundNode(i, temp);
            temp = node;
        }
        head.next = temp;
        int count = 0;
        int out = 0;
        RoundNode current = head;
        while (count < target) {
            out = current.next.next.number;
            RoundNode next_1 = current.next.next.next;
            current.next.next = next_1;
            current = next_1;
            count++;
        }
        return "" + out;
    }

    public static void main(String[] args) {
        System.out.println(solution("3"));
    }
}

