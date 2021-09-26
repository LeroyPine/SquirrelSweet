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

        // 递归进行排序合并 -- 每次取一半

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = head.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

      /// 合并两个链表  return  merge(sortList(head),sortList(head2));

        return null;

    }
}
