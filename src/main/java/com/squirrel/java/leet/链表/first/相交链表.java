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
 * @date Created in 2021年04月17日 16:37
 * @since 1.0
 */
public class 相交链表 {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA != null) {
                tempA = tempA.next;
            } else {
                tempA = headB;
            }

            if (tempB != null) {
                tempB = tempB.next;
            } else {
                tempB = headA;
            }
        }
        return tempA;
    }
}
