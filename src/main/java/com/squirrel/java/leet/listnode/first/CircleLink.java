package com.squirrel.java.leet.listnode.first;

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
 * @date Created in 2021年04月26日 16:16
 * @since 1.0
 */
public class CircleLink {

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        //
        ListNode slow = head, fast = head;

        // 进入环内去追

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                // 慢指针与快指针相遇   然后在圈内进行~~
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;

    }
}
