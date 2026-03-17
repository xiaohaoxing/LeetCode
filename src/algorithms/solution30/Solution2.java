
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
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        int n = words[0].length();
        for (int offset = 0; offset < n; offset++) {
            int start = offset;
            int end = offset;
            HashMap<String, Integer> currentCounts = new HashMap<>();
            while (start + n * words.length <= s.length()) {
                if (end - start == words.length * n) {
                    
                    boolean success = true;
                    for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                        if (!currentCounts.containsKey(entry.getKey())
                                || !currentCounts.get(entry.getKey()).equals(entry.getValue())) {
                            success = false;
                        }
                    }
                    if (success) {
                        results.add(start);
                    }
                    // pop one
                    String first = s.substring(start, start + n);
                    currentCounts.put(first, currentCounts.get(first) - 1);

                }
                // push
                if (end + n > s.length()) {
                    break;
                }
                String current = s.substring(end, end + n);
                if (currentCounts.containsKey(current)) {
                    currentCounts.put(current, currentCounts.get(current) + 1);
                } else {
                    currentCounts.put(current, 1);
                }
                if (end - start == words.length * n) {
                    start += n;
                    end += n;
                } else {
                    end += n;
                }

            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        List<Integer> result = test.findSubstring("barfoothefoobarman",
                new String[] { "foo","bar"});
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