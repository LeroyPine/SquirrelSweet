package com.squirrel.java.leet.链表.meet;

public class 反转链表2 {

    /**
     * 思路：
     * 1.首先找到左区间的位置
     * 2.然后利用头插法（此时的头为左区间的前一个节点）
     * 3.一次遍历反转链表
     * // 例子   1 3 4 5 6    1 5 4 3 6
     *
     * @param head  链表
     * @param left  左区间
     * @param right 右区间
     * @return 反转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果链表为空,那么直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 哑结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // prev - 哑结点
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 此时的prev为左区间的头一个节点
        ListNode curr = prev.next;
        // 进行链表反转
        // 例子   1 3 4 5 6    1 5 4 3 6
        for (int i = 0; i < right - left; i++) {
            // 获取要反转头节点的下一个节点
            ListNode next = curr.next;
            // 穿针引线 - 当前节点的下一个节点指向要后一个节点
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }
}
