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

    /**
     * 思路：
     * 1.利用哑结点来解决头结点反转需要特殊判断的问题
     * 2.使用栈来作为反转的辅助工具
     * 3.记得将不够k个反转的元素,拼接在链表的尾部。
     *
     * @param head 链表
     * @param k    几个节点进行反转
     * @return 反转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        Deque<ListNode> stack = new LinkedList<>();
        while (true) {
            // 当前节点的下一个
            ListNode temp = head;
            int count = 0;
            for (int i = 0; i < k && temp != null; i++) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            if (count != k) {
                break;
            } else {
                // 出栈
                while (!stack.isEmpty()) {
                    prev.next = stack.pop();
                    prev = prev.next;
                }
                // 拼接
                prev.next = temp;
                head = temp;

            }
        }
        return dummyNode.next;

    }

}
