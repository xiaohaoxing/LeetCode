package algorithms.solution2707;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private HashMap<Character, HashMap> dict;
    private char[] chars;

    public int minExtraChar(String s, String[] dictionary) {
        // build a tree for dict
        chars = s.toCharArray();
        dict = new HashMap<>();
        for (String word : dictionary) {
            HashMap<Character, HashMap> current = dict;
            for (char c : word.toCharArray()) {
                if (current.containsKey(c)) {
                    current = current.get(c);
                    continue;
                }
                current.put(c, new HashMap<Character, HashMap>());
            }
        }
        return 0;
    }

    public int minExtraChar(HashMap currentCandidate, int currentPos, int remaining) {
        if (currentCandidate.isEmpty()) {
            if (currentPos == chars.length - 1) {
                return remaining;
            } else {
                return minExtraChar(dict, currentPos, remaining);
            }
        }
        if (currentCandidate.containsKey(chars[currentPos])) {

        } else {

        }
        return 0;
    }

    public static void main(String[] args) {
//        String target = "leetcodes";
//        String[] dict = ["leet", "code"];
    }
}
