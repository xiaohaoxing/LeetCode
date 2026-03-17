package test;

/**
 * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
输入两行，第一行n,k，第二行为数组序列。输出最大值。

输入:
n=5 k=5
arr=[4,7,2,10,5]
输出:4
解释：最多可以把它分成5段长度为4的木头
 */
public class Didi2 {
    public int cut(int[] lengths, int k) {
        int max = 0;
        int sum = 0;
        for(int i= 0;i< lengths.length;i++) {
            sum += lengths[i];
            if(lengths[i] > max) {
                max = lengths[i];
            }
        }
        if(sum < k) {
            return 0;
        }
        int to = max;
        int from = 1;
        while(from < (to - 1)) {

            int mid = (from + to) / 2;
            int count = tryCut(lengths, mid);
            System.out.println("try cut with length " + mid + ", get " + count + " pieces.");
            if(count >= k) {
                from = mid;
            } else {
                to = mid;
            }
            System.out.println("from=" + from + ",to=" + to);
        }
        return from;
    }

    public int tryCut(int[] lengths, int m) {
        int count = 0;
        for(int i = 0;i<lengths.length;i++) {
            count += (lengths[i]/m);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] case1 = new int[]{4,7,2,10,5};
        int k = 5;
        Didi2 test = new Didi2();
        int result1 = test.cut(case1, k);
        System.out.println(result1);
    }
}
