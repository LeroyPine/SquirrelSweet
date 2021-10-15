package com.squirrel.java.leet.链表.meet;

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
        ListNode curr = dummyNode;


        while (true) {
            // 统计是否到k个元素
            int count = 0;
            // 临时引用
            ListNode temp = head;
            // 如果不够 k 个保持原状
            for (int i = 0; i < k && temp != null; i++) {
                stack.add(temp);
                temp = temp.next;
                count++;
            }
            if (count < k) {

                break;
            }
            // 出站
            while (!stack.isEmpty()) {
                curr.next = stack.pop();
                curr = curr.next;
            }
            // 不满足k个继续拼接
            curr.next = head;
            // temp 为下一段的起点
            head = temp;
        }
        return dummyNode.next;

    }


}
