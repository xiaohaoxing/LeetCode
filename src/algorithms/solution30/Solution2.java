
package algorithms.solution30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        int n = words[0].length();
        for (int offset = 0; offset < n; offset++) {
            int start = offset;
            int end = offset;
            HashMap<String, Integer> currentCounts = new HashMap<>();
            int validCount = 0;
            while (end + n <= s.length()) {
                String current = s.substring(end, end + n);
                end += n;
                if(wordCounts.containsKey(current)) {
                    currentCounts.put(current, currentCounts.getOrDefault(current, 0) + 1);
                    validCount ++;
                    while(currentCounts.get(current) > wordCounts.get(current)) {
                        // move start
                        String left = s.substring(start, start + n);
                        currentCounts.put(left, currentCounts.get(left) - 1);
                        validCount --;
                        start += n;
                    } 
                    if(validCount == words.length) {
                        results.add(start);
                    }
                } else {
                    currentCounts.clear();
                    start = end;
                    validCount = 0;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        List<Integer> result = test.findSubstring("barfoothefoobarman",
                new String[] { "foo", "bar" });
        for (Integer str : result) {
            System.out.print(str + ",");
        }
        System.out.println("");
    }

    public static <K, V> void printMap(HashMap<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(String.format("(%s=%s),", entry.getKey().toString(), entry.getValue().toString()));
        }
        System.out.println();
    }
}