package com.squirrel.java.leet.链表.meet;

import java.util.List;

public class 翻转链表2 {


    // 翻转链表  头插法
    public ListNode reverse(ListNode node) {

        // 1 2 3 4 5

        ListNode newHead = new ListNode(-1);
        while (node != null) {

            ListNode next = node.next;
            next.next = newHead.next;
            newHead.next = node;
            node = next;
        }
        return newHead.next;


    }


    /**
     * 采用头插法进行翻转链表: 创建一个头结点,在该节点后插入链表的值
     *
     * @param node
     * @return
     */
    public ListNode reverseV3(ListNode node) {
        // 节点为null或者只有一个节点 那么直接返回
        if (node == null || node.next == null) {
            return node;
        }
        // 创建一个头结点
        ListNode headNode = new ListNode(-1);
        // 链表的节点依次插入到头结点后

        //   1  3  5  6  8
        // 头插法
        while (node != null) {

            // 记录node 的下一个节点
            ListNode next = node.next;
            // 头插入
            node.next = headNode.next;
            headNode.next = node;

            node = next;
        }


        return headNode.next;

    }

    public ListNode reverse11(ListNode node) {
        // 节点为null或者只有一个节点 那么直接返回

        if (node == null || node.next == null) {
            return node;
        }

        ListNode headNode = new ListNode(-1);

        while (node != null) {

            ListNode next = node.next;

            node.next = headNode.next;

            headNode.next = node;

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

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next = null;

        for (int i = 0; i < n - m; i++) {

            next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;

        }

        return dummyNode.next;

    }

    /**
     * ListNode dummyNode = new ListNode(-1);
     * dummyNode.next = head;
     * ListNode pre = dummyNode;
     * for (int i = 0; i < left - 1; i++) {
     * pre = pre.next;
     * }
     * ListNode cur = pre.next;
     * ListNode next;
     * for (int i = 0; i < right - left; i++) {
     * next = cur.next;
     * cur.next = next.next;
     * next.next = pre.next;
     * pre.next = next;
     * }
     * return dummyNode.next;
     * }
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param args
     */


    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;


        // 第3个节点
        for (int i = 0; i < 2; i++) {
            a = a.next;
        }
        ListNode cc = a;

    }
}
