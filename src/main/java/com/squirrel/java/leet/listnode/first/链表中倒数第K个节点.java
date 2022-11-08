package com.squirrel.java.leet.listnode.first;

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
 * @date Created in 2021年05月14日 19:42
 * @since 1.0
 */
public class 链表中倒数第K个节点 {


    public ListNode getKthFromEnd(ListNode head, int k) {

        // stack

        // 双指针  a  b

        Deque<ListNode> stack = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int j = 1;
        while (!stack.isEmpty()) {

            if (j == k) {
                return stack.pop();
            }
            stack.pop();
            j++;
        }

        return null;
    }
}
