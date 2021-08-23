package com.squirrel.java.leet.链表;

import java.util.LinkedList;
import java.util.Queue;

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
 * @date Created in 2021年05月17日 13:26
 * @since 1.0
 */
public class 分割链表 {

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }
        // 额外存储空间 栈
        Queue<ListNode> queueL = new LinkedList<>();
        Queue<ListNode> queueR = new LinkedList<>();

        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            if (temp.val < x) {
                queueL.add(temp);
            } else {
                queueR.add(temp);
            }
            temp.next = null;
            temp = next;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tempNode = dummyNode;
        // 出列
        while (!queueL.isEmpty()) {
            tempNode.next = queueL.remove();
            tempNode = tempNode.next;
        }
        while (!queueR.isEmpty()) {
            tempNode.next = queueR.remove();
            tempNode = tempNode.next;
        }
        return dummyNode.next;
    }


    // 定义两个链表
    // 小的指向大的

    public ListNode partitionII(ListNode head, int x) {

        //
        ListNode tempSmall = new ListNode(-1);
        ListNode tempLarge = new ListNode(-1);

        ListNode small = tempSmall;
        ListNode large = tempLarge;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                tempSmall.next = curr;

                tempSmall = tempSmall.next;
            } else {
                tempLarge.next = curr;
                tempLarge = tempLarge.next;
            }

            curr = curr.next;
        }
        tempLarge.next = null;
        tempSmall.next = large.next;

        return small.next;
    }
}
