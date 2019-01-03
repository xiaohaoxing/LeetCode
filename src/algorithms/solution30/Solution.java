package algorithms.solution30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
            if (match(chars, wordList, i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean match(char[] chars, ArrayList<String> words, int from) {
        ArrayList<String> remains = words;
        int pos = from;
        while (!remains.isEmpty()) {
            String matched = matchOne(chars, remains, pos);
            if (matched == null) {
                return false;
            }
            pos += matched.length();
            remains.remove(matched);
        }
        return true;
    }

    public static String matchOne(char[] chars, ArrayList<String> words, int from) {
        for (String s : words) {
            if (chars.length - from < s.length()) {
                continue;
            }
            int pos = from;
            boolean match = true;
            for (char c : s.toCharArray()) {
                if (chars[pos] != c) {
                    match = false;
                    break;
                }
                pos++;
            }
            if (match) {
                return s;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String a = "foobarmanbarfoo";
        List<String> wordList = new ArrayList<>(Arrays.asList("foo", "bar"));
        String[] words = new String[]{"foo", "bar"};
        Solution test = new Solution();
        List<Integer> result = test.findSubstring(a, words);
        algorithms.utils.ListPrinter.printList(result);

    }
}
