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
 * @date Created in 2021年08月25日 17:31
 * @since 1.0
 */
public class 链表是否有环 {


    /**
     * 链表是否有环:  通过快慢指针,如果有环 快指针一定可以追上他
     *
     * @param head 头
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null) {
                return false;
            }
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }


    public boolean hasCycleV2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null) {
                return false;
            }
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return false;
            }
            // fast--
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode hasCycle23(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            // 快慢指针相遇
            if (fast == slow) {
                slow = head;
                fast = fast.next;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;

    }

    /**
     * @param head
     * @return
     */
    public ListNode hasCycle2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        //
        while (fast != null && fast.next != null) {

            // 如果快慢指针相遇
            if (slow == fast) {
                slow = head;
                fast = fast.next;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        return null;
    }
}
