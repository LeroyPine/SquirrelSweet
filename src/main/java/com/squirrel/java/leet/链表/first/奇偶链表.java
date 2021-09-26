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
 * @date Created in 2021年05月17日 19:10
 * @since 1.0
 */
public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {


        // 定义一个奇数链表和一个偶数链表
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // 奇->偶的下一个
            odd.next = even.next;
            odd = odd.next;
            //
            even.next = odd.next;
            even = even.next;

        }
        odd.next = evenHead;

        return head;

    }
}
