package com.squirrel.java.leet.listnode.meet;

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
 * @date Created in 2021年10月15日 10:33
 * @since 1.0
 */
public class K个一组翻转链表 {


    public ListNode reverseKGroup(ListNode head, int k) {

        // K个一组反转链表  采用压栈的方式

        Deque<ListNode> stack = new LinkedList<>();

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = dummyNode;

        while (true) {

            // k个一组
            ListNode temp = head;
            int count = 0;
            while (temp != null && count!=k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            if (count < k) {
                break;
            }
            while (!stack.isEmpty()) {

                curr.next = stack.pop();
                curr = curr.next;
            }
            // 不足k接着拼 默认将后面的拼接上
            curr.next = temp;
            head = temp;
        }
        return dummyNode.next;
    }


}
