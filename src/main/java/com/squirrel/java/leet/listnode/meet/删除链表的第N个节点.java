package com.squirrel.java.leet.listnode.meet;

public class 删除链表的第N个节点 {


    /**
     * 思路:
     * 1. 使用哑结点,来解决需要特殊判断头结点的问题
     * 2. 快慢指针,记住是删除,所以second 要走到要删除节点之前的那个节点
     *
     * @param head 头结点
     * @param n    第n个结点
     * @return 删除第N个结点之后的链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode first = head;
        ListNode second = dummyNode;
        // 遍历链表
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return dummyNode.next;
    }

}
