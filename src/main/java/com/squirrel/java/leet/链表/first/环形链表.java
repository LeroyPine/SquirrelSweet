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
 * @date Created in 2021年04月17日 14:27
 * @since 1.0
 */
public class 环形链表 {


    public static boolean hasCycle(ListNode head) {
        // 相互追逐
        if (head == null || head.next == null) {
            return false;
        }

        // 1.2
        ListNode slow = head;
        ListNode fast = head.next;

        // 如果 slow 不相遇 fast 那么就没有环

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
