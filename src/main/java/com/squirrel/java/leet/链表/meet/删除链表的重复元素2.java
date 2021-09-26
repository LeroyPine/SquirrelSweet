package com.squirrel.java.leet.链表.meet;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 * @date Created in 2021年09月11日 12:06
 * @since 1.0
 */
public class 删除链表的重复元素2 {


    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                final int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
