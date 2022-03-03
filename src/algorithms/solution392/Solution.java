package algorithms.solution392;

import java.util.Date;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        for (int i = 0; count < s.length() && i < t.length(); i++) {
            if (s.charAt(count) == t.charAt(i)) {
                count++;
            }
        }
        return count == s.length();
    }

    public static void main(String[] args) {

//        String s = "rjufvjafbxnbgriwgokdgqdqewn";
//        String t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";
        String s = "";
        String t = "ahbgdc";
        Solution test = new Solution();
        long startTime = System.currentTimeMillis();
        boolean result = test.isSubsequence(s, t);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("spend time:" + (endTime - startTime) + "ms");
    }
}
