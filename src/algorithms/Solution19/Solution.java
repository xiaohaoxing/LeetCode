package algorithms.Solution19;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 注意：
 * 1.如果长度为1怎么办              ->          特别处理，直接返回null
 * 2.如果要移除头节点怎么办        ->
 * 3.如果移除尾节点怎么办
 */
/**  status: AC  **/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //长度为1的情况必须特别处理
        if (head.next == null) {
            return null;
        }
        //构建一个虚拟头节点，用于移除真正的头节点方便。
        ListNode leading = new ListNode(0);
        leading.next = head;
        ListNode from = leading;
        ListNode to = leading;
        //将to指针向后移动n-1个
        for (int i = 0; i < n; i++) {
            to = to.next;
        }
        //将to和from同步向后移动至to到末尾
        while (to.next != null) {
            from = from.next;
            to = to.next;
        }
        //移除from后一个元素。
        from.next = from.next.next;
        //这里不要返回head。。否则移除头节点会失效。
        return leading.next;
    }


    public static void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        ListNode result = new Solution().removeNthFromEnd(a,2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
    }
}