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
 * @date Created in 2021年05月14日 19:22
 * @since 1.0
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {

        ListNode sortListNode = ListNodeFactory.getSortListNode();

        System.out.println(reversePrint(sortListNode));

        System.out.println(reverseV2(sortListNode));

    }

    // 从尾到头   1 2 3 4 5 5 6
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // 链表翻转  在进行打印

        ListNode prev = null;
        ListNode curr = head;

        int length = 0;
        while (curr != null) {
            // 链表翻转
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            length++;
        }

        // 打印prev

        int[] array = new int[length];

        int j = 0;
        while (prev != null) {
            int val = prev.val;
            prev = prev.next;
            System.out.println(val);
            array[j] = val;
            j++;
        }

        return array;
    }


    public static int[] reverseV2(ListNode node) {

        if (node == null) {
            return new int[0];
        }
        // 使用栈来进行
        Deque<ListNode> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        // pop

        int[] array = new int[stack.size()];
        int j = 0;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            array[j++] = pop.val;
        }
        return array;
    }
}
