package com.squirrel.java.leet.链表.first;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年05月14日 17:38
 * @since 1.0
 */
public class 二级制链表转整数 {

    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int ans = 0;
        while (curr != null) {
            ans = ans * 2 + curr.val;
            curr = curr.next;
        }
        return ans;
    }
}
