package com.squirrel.java.leet.链表;

import java.util.HashMap;
import java.util.HashSet;
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
 * @date Created in 2021年05月14日 14:04
 * @since 1.0
 */
public class 删除链表中重复的元素 {

    /**
     * 删除链表中重复的元素
     * <p>
     * 连续的  那么 直接比较当前与下一个的值
     * <p>
     * 1,2,2,3,4,4,5
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = deleteDuplicates(ListNodeFactory.getSortListNode());
        System.out.println(listNode);
    }
}
