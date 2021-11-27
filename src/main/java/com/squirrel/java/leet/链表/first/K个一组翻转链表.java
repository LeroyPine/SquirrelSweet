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

    // 利用栈来实现反转
    // 1 2 3 4 5 6 7   ||  2 1 4 3 6 5 7
    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果为空或者只有一个元素就直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        Deque<ListNode> stack = new LinkedList<>();
        while (true) {
            int count = 0;
            ListNode temp = head;
            while (count < k && temp != null) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            // k个拼接
            if (count == k) {
                while (!stack.isEmpty()) {
                    prev.next = stack.pop();
                    prev = prev.next;
                }

            } else {
                break;
            }
            prev.next = temp;
            head = temp;

        }
        return dummyNode.next;
    }


    public static void main(String[] args) {


        int count =0;
        while (count<2){
            System.out.println("12");
            count++;
        }
    }
}
