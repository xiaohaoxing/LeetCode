package algorithms.solution205;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reMap = new HashMap<>();
        if (s.isEmpty()) {
            return t.isEmpty();
        }
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) || reMap.containsKey(t.charAt(i))) {
                if (!reMap.containsKey(t.charAt(i)) || !map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
                reMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        Solution test = new Solution();
        boolean result = test.isIsomorphic(s, t);
        System.out.println(result);
    }

}
