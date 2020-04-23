package algorithms.solution929;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> actualEmails = new HashSet<>();
        for (String email : emails) {
            String[] pieces = email.split("@");
            actualEmails.add(pieces[0].split("\\+")[0].replaceAll("\\.", "") + '@' + pieces[1]);
        }
        return actualEmails.size();
    }
    
    public static void main(String[] args) {
        
        String[] test = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int result = new Solution().numUniqueEmails(test);
    }
}
