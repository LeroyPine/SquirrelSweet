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
 * @date Created in 2021年04月17日 14:27
 * @since 1.0
 */
public class 环形链表 {


    /**
     * 思路：
     * 快慢指针互相追逐
     *
     * @param head 头结点
     * @return 是否是环形链表
     */
    public boolean hasCycle(ListNode head) {
        // 相互追逐
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针的板子 我就用这个啦。
        // 1 2 3 4 5 6     slow 1 fast 2   slow 2 fast 4  慢指针一步 快指针两步
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}
