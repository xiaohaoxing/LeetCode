package algorithms.solution893;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        List<CharSetPair> uniqueList = new ArrayList<>();
        for (String a : A) {
            // construct the sets
            char[] chars = a.toCharArray();
            CharSetPair pair = new CharSetPair();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    pair.evenSet.put(chars[i], pair.evenSet.getOrDefault(chars[i], 0) + 1);
                } else {
                    pair.oddSet.put(chars[i], pair.oddSet.getOrDefault(chars[i], 0) + 1);
                }
            }
            if (!uniqueList.contains(pair)) {
                uniqueList.add(pair);
            }
        }
        return uniqueList.size();
    }

    public static void main(String[] args) {
        String[] in = new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        String[] in2 = new String[]{"ababaa", "aaabaa"};
        Solution test = new Solution();
        System.out.println(test.numSpecialEquivGroups(in));
    }
}

class CharSetPair {
    HashMap<Character, Integer> oddSet;
    HashMap<Character, Integer> evenSet;

    public CharSetPair() {
        oddSet = new HashMap<>();
        evenSet = new HashMap<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharSetPair that = (CharSetPair) o;
        return Objects.equals(oddSet, that.oddSet) &&
                Objects.equals(evenSet, that.evenSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oddSet, evenSet);
    }
}
