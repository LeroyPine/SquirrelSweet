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
 * @date Created in 2021年08月25日 16:41
 * @since 1.0
 */
public class 分割链表 {

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于  x  的节点都在大于或等于  x  的节点之前
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 构造两个链表
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
