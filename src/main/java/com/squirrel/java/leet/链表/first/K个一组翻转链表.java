package com.squirrel.java.leet.链表.first;

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


    // 1 2 3 4 5 6 7   ||  2 1 4 3 6 5 7
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        // 使用栈进行存储,然后在进行拼接
        Deque<ListNode> stack = new LinkedList<>();
        // 如果
        while (true) {

            ListNode temp = head;


            int count = 0;
            // k个反转
            for (int i = 0; i < k && temp != null; i++) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            //
            if (count < k) {
                prev.next = temp;
                break;
            }

            // 进行反转
            while (!stack.isEmpty()) {
                prev.next = stack.pop();
                prev = prev.next;
            }

            head = temp;
        }

        return dummyNode.next;

    }

}
