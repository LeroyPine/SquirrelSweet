package com.squirrel.java.leet.链表.meet;

public class 删除链表的第N个节点 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummyNode;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 此时second 为第n各节点

        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return dummyNode.next;

        // 先走到2
        //   1  2  3  4  5
    }

}
