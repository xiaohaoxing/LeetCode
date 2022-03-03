package algorithms.solution49;

import java.util.*;

/**
 * 将字符映射成数字然后求和获取唯一的标识码，这里是行不通的。。
 * 1. 先尝试仅根据 map 转换：发现 aacc 和 bd 编码相同
 * 2. 再尝试先按照长度切分，再按照特征码划分：发现 huh 和 tit 相同
 * 3.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] dict = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432};
        Map<Integer, List<String>> values = new HashMap<>();
        // 先按长度切分
        for (String str : strs) {
            if (values.get(str.length()) != null) {
                values.get(str.length()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                values.put(str.length(), list);
            }
        }
        // 再分别拆分
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : values.values()) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : list) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                    sum += dict[c - 'a'];
                }
                if (map.get(sum) != null) {
                    map.get(sum).add(str);
                } else {
                    List<String> l = new ArrayList<>();
                    l.add(str);
                    map.put(sum, l);
                }
            }
            result.addAll(map.values());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] data = new String[]{"huh", "tit"};
        Solution test = new Solution();
        List<List<String>> result = test.groupAnagrams(data);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
}

