package com.squirrel.java.leet.listnode.meet;

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
 * @date Created in 2021年08月25日 17:31
 * @since 1.0
 */
public class 环形链表 {


    /**
     * 链表是否有环:  通过快慢指针,如果有环 快指针一定可以追上他
     *
     * @param head 头
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }
}
