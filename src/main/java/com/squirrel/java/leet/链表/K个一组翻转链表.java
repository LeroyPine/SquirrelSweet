package com.squirrel.java.leet.链表;

import java.util.Deque;
import java.util.LinkedList;

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
 * @date Created in 2021年08月03日 14:36
 * @since 1.0
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {

        /**
         * 思路： k个元素压栈,出栈的时候拼接在原链表上
         */
/*
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        Deque<ListNode> stack = new LinkedList<>();
        while (true) {
            // 临时变量
            ListNode temp = head;
            int count = 0;
            while (temp != null && count < k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            // 如果不到k个那么直接跳出
            if (count != k) {
                prev.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
            // 将翻转后的链表进行拼接
            prev.next = temp;
            head = temp;
        }
        return dummyNode.next;*/
        return null;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        Deque<ListNode> stack = new LinkedList<>();
        while (true) {
            ListNode temp = head;
            int count = 0;
            while (temp != null && count < k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            // 剩余元素不满足k个直接跳出
            if (count != k) {
                prev.next = head;
                break;
            }
            //
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }
            //
            prev.next = temp;
            head = temp;
        }
        return dummyNode.next;
    }


}
