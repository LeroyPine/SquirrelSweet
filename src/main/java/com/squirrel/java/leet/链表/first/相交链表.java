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

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(10);

        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(11);
        ListNode n7 = new ListNode(12);

        n4.next = n5;
        n5.next = n6;
        n6.next = n7;


        ListNode intersectionNode = getIntersectionNode(n1, n4);
        System.out.println(intersectionNode);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2) {
            if (head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }

            if (head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }
        return head1;


    }
}
