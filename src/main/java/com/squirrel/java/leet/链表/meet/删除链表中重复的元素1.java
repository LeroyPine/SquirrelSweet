package com.squirrel.java.leet.链表.meet;

public class 删除链表中重复的元素1 {


    /**
     * 删除链表中重复的元素I
     *
     * @param head 头结点
     * @return 处理过的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
