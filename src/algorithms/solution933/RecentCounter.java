package algorithms.solution933;

import java.util.LinkedList;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class RecentCounter {
    LinkedList<Integer> previous;
    public RecentCounter() {
        previous = new LinkedList<>();
    }
    
    public int ping(int t) {
        previous.add(t);
        while(previous.getFirst() < (t - 3000)) {
            previous.remove(0);
        }
        return previous.size();
    }
    
    
    public static void main(String[] args) {
        RecentCounter test = new RecentCounter();
        System.out.println(test.ping(0));
        System.out.println(test.ping(1));
        System.out.println(test.ping(2));
        System.out.println(test.ping(3000));
        System.out.println(test.ping(3002));
    }
}
