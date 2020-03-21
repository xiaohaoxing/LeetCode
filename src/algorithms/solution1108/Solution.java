package algorithms.solution1108;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        String[] n = address.split("[.]");
//        for (int i = 0; i < n.length; i++) {
//            sb.append(n[i]);
//            sb.append("[.]");
//        }
//        return sb.substring(0, sb.length() - 3);
        return n[0] + "[.]" + n[1] + "[.]" + n[2] + "[.]" + n[3];

    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.defangIPaddr("0.0.0.0"));
    }
}
