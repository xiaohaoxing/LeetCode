package algorithms.solution14;

/**
 *
 * Created by Lenovo on 16.9.30.
 * 查找指定一系列字符串的公共前缀
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder common = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i ++) {
            char tmp = strs[0].charAt(i);
            for(int j = 1;j < strs.length; j++) {
                //后面的字符串到目前的位置就结束，或者目前位置不相同，就直接返回了
                if(strs[j].length()<=i||strs[j].charAt(i)!=tmp){
                    return common.toString();
                }
            }
            common.append(strs[0].charAt(i));
        }
        return common.toString();
    }

    public static void main(String args[]) {
        String[] strs = {"abc","abcd","abcde"};
        Solution14 test = new Solution14();
        System.out.println(test.longestCommonPrefix(strs));
    }
}
