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
 * @date Created in 2021年08月25日 16:14
 * @since 1.0
 */
public class 合并两个升序的链表 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (l1 != null && l2 != null) {


            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummyNode.next;
    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        //
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;

        while (l1 != null && l2 != null) {
            //
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummyNode.next;
    }


}
