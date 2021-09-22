package com.squirrel.java.leet.链表.meet;

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
 * @date Created in 2021年09月22日 15:19
 * @since 1.0
 */
public class 相交链表 {

    //  1 2  3   4  5      7 8 3
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA.next;
            if (tempA == null) {
                tempA = headB;
            }
            tempB = tempB.next;
            if (tempB == null) {
                tempB = headA;
            }
        }
        return tempA;
    }
}
