package com.squirrel.java.leet.链表.meet;

public class 删除链表的第N个节点 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        for (int i = 0; i < n; i++) {
            first = first.next;
            second = second.next;
        }

        // 此时second 为第n各节点

        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return dummyNode.next;

    }


    /**
     *     //使用双指针
     *
     *         ListNode dummyNode = new ListNode(-1, head);
     *
     *         // 使用双指针
     *
     *
     *         ListNode first = head;
     *         ListNode second = head;
     *
     *         // first 先走n
     *         for (int i = 0; i < n; i++) {
     *             first = first.next;
     *         }
     *
     *         // second 在走n
     *
     *         while (first != null) {
     *
     *             first = first.next;
     *             second = second.next;
     *         }
     *
     *
     *         if (second != null && second.next != null) {
     *             second.next = second.next.next;
     *         }
     *         return dummyNode.next;
     */
}
