package com.squirrel.java.leet.链表.meet;

public class 环形链表2 {


    /**
     * 思路:
     * 1.寻找成环的节点
     * 2.首先让快指针追上慢指针
     * 3.然后慢指针指向头结点,快指针指向下一个节点,在一起走。
     * 数学题:
     * a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     * a=c+(n−1)(b+c)
     *
     * @param head 头结点
     * @return 链表成环的位置
     */
    public ListNode detectCycle(ListNode head) {
        // 头结点为空
        if (head == null || head.next == null) {
            return null;
        }
        // 定义两个快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            // 如果两个节点相遇
            if (slow == fast) {
                slow = head;
                fast = fast.next;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
