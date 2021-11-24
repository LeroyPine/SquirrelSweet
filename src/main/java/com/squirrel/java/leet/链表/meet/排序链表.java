package com.squirrel.java.leet.链表.meet;

import java.util.List;

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
 * @date Created in 2021年09月26日 16:33
 * @since 1.0
 */
public class 排序链表 {

    // 排序链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(head2));

    }

    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {

            if (temp1.val < temp2.val) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }

        if (temp1 != null) {
            prev.next = temp1;
        }
        if (temp2 != null) {
            prev.next = temp2;
        }
        return dummyNode.next;


    }
}
