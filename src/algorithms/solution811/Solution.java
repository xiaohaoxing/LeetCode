package algorithms.solution811;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String domain : cpdomains) {
            String[] pair = domain.split(" ");
            int count = Integer.parseInt(pair[0]);
            String[] pieces = pair[1].split("\\.");
            String current = "";
            for (int i = pieces.length - 1; i >= 0; i--) {
                if(current.isEmpty()){
                    current = pieces[i];
                }else {
                    current = pieces[i] + "." + current;
                }
                if (result.containsKey(current)) {
                    result.put(current, result.get(current) + count);
                } else {
                    result.put(current, count);
                }
            }
        }
        return result.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        String[] test = new String[]{"9001 discuss.leetcode.com"};
        List<String> result = new Solution().subdomainVisits(test);
        System.out.println(result);
    }
}
