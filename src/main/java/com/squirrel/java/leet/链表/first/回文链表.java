package com.squirrel.java.leet.链表.first;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 *
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月23日 13:02
 * @since 1.0
 */
public class 回文链表 {

    /**
     * 思路:
     * 1.通过栈实现
     * 2.先将链表进行压栈
     * 3.然后出栈进行对比,如果都是相同的,则是回文链表
     *
     * @param head 头结点
     * @return 是否是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        // 可以用栈来实现
        Deque<Integer> stack = new LinkedList<>();
        ListNode temp1 = head;
        while (temp1 != null) {
            stack.push(temp1.val);
            temp1 = temp1.next;
        }
        ListNode temp2 = head;
        while (temp2 != null) {
            if (temp2.val != (stack.pop())) {
                return false;
            }
            temp2 = temp2.next;
        }
        return true;
    }
}