package com.squirrel.java.leet.链表.meet;

public class 翻转链表2 {

    /**
     * 采用头插法进行翻转链表: 创建一个头结点,在该节点后插入链表的值
     *
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node) {
        // 节点为null或者只有一个节点 那么直接返回
        if (node == null || node.next == null) {
            return node;
        }
        // 创建一个头结点
        ListNode headNode = new ListNode(-1);
        // 链表的节点依次插入到头结点后

        while (node != null) {
            // 当前节点的下一个节点
            ListNode next = node.next;
            // 当前节点的下一个节点为头结点
            node.next = headNode.next;
            // 头结点的下一个节点为当前节点
            headNode.next = node;
            // 当前节点切换成next节点
            node = next;
        }
        return headNode.next;

    }


    /**
     * 翻转链表 从m到n之间的
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // 首先找到第m个节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = head;

        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }
        // curr 为第m个节点


        return null;

    }

}
