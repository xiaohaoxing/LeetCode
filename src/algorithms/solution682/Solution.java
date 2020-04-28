package algorithms.solution682;

import java.util.Stack;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> prev = new Stack<>();
        for (String op : ops) {
            int pre;
            int prepre;
            switch (op){
                case "C":
                    pre = prev.pop();
                    sum -= pre;
                    break;
                case "D":
                    pre = prev.peek();
                    int current = pre*2;
                    prev.push(current);
                    sum += current;
                    break;
                case "+":
                    pre = prev.pop();
                    prepre = prev.pop();
                    prev.push(prepre);
                    prev.push(pre);
                    prev.push(pre+prepre);
                    sum += pre + prepre;
                    break;
                default:
                    int num = Integer.parseInt(op);
                    prev.push(num);
                    sum += num;
            }
        }
        return sum;
    }
}
