package algorithms.solution791;

import java.util.*;

/**
 * 我用的是常规的 List + 排序方法
 * 更优解法：由于节点的范围是有限的（26 个字母），因此使用桶排序会更快。创建 26 个桶，将待排序数据塞到桶里，再去遍历 order 提取出来。最后追加剩余的数据。
 * @author xiaohaoxing
 */
public class Solution {
    public String customSortString(String order, String s) {
        ArrayList<Character> sorted = new ArrayList<>();
        StringBuilder nosorted = new StringBuilder();
        for (char c : s.toCharArray()) {
            boolean sort = false;
            for (char t : order.toCharArray()) {
                if (c == t) {
                    sorted.add(c);
                    sort = true;
                }
            }
            if (!sort) {
                nosorted.append(c);
            }
        }
        Comparator<Character> comparator = Comparator.comparingInt(order::indexOf);
        sorted.sort(comparator);
        for (Character c : sorted) {
            nosorted.append(c);
        }
        return nosorted.toString();
    }


    public static void main(String[] args) {
        String testcase = "abcd";
        String order = "bcafg";
        Solution test = new Solution();
        String result = test.customSortString(order, testcase);
        System.out.println(result);
    }
}
