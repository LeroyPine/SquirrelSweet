package com.squirrel.java.leet.listnode.first;

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
 * @date Created in 2021年05月15日 15:17
 * @since 1.0
 */
public class 两个链表的第一个交点 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a != null) {
                a = a.next;
            } else {
                a = headB;
            }

            if (b != null) {
                b = b.next;
            } else {
                b = headA;
            }
        }
        return a;

    }
}
