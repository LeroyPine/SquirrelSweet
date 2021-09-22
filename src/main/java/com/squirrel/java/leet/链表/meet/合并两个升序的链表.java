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


    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 != null) {
            curr.next = node1;
        }
        if (node2 != null) {
            curr.next = node2;
        }
        return dummyNode.next;

    }


}
