package algorithms.solution22;

/**
 * 给定一个数字代表括号的对数，求所有可能的括号匹配的情况
 * 如 in = 3
 * 输出()()()所有可能的嵌套情况,共5种。
 * <p>
 * 2个栈：前和后括号
 * 如果都有则容量*2，都递归一次后续
 * 如果只有一个就直接取
 * 如果都没有就结束了
 * 所以：a:['(','(']
 * b:[')',')',')']
 * (实现的时候用int 表示就行了)
 * result = ['(']
 * *2
 * result=['()','((']
 */
public class Solution {
//    public List<String> generateParenthesis(int n) {
//
//    }
//
//    public List<String> appendOne(List<String> before, int left, int right) {
//        // 已经匹配完了。
//        if(left == 0 &&right == 0) {
//            return before;
//        }
//        // 左括号或者右括号用完了
//        if(left == 0 || right == 0){
//            for(int i = 0; i < before.size();i ++) {
//                before.set(i, before.get(i) + (left == 0?')':'('));
//            }
//            return before;
//        } else {
//            // 左右括号都还能加
//            List<String> after = new LinkedList<>();
//            for(String str:before) {
//                after.addAll(appendOne(after.add(str + '('), left - 1, right);
//            }
//        }
//
//    }
}
