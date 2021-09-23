package com.squirrel.java.leet.链表.meet;

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
 * @date Created in 2021年09月23日 10:11
 * @since 1.0
 */
public class 重排链表 {

    // 重排链表 ： 寻找链表重点  +  链表逆序 +  合并链表
    public void reorderList(ListNode head) {
        //
        if (head == null) {
            return;
        }
        ListNode middleNode = middle(head);
        //
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        // 翻转右部分链表
        l2 = reverseL(l2);
        // 合并两个链表
        merge(head, l2);
    }

    private void merge(ListNode l1, ListNode reL2) {
        ListNode temp1;
        ListNode temp2;

        while (l1 != null && reL2 != null) {

            temp1 = l1.next;
            temp2 = reL2.next;

            l1.next = reL2;
            l1 = temp1;

            reL2.next = l1;
            reL2 = temp2;
        }
    }

    private ListNode reverseL(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        //  1  2  3  4  5
        while (head != null) {
            ListNode next = head.next;
            head.next = dummyNode.next;
            dummyNode.next = head;
            head = next;
        }
        return dummyNode.next;

    }

    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
