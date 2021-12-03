package com.squirrel.java.leet.链表.first;

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
 * @date Created in 2021年05月08日 10:58
 * @since 1.0
 */
public class 反转链表2 {














    // 1 2 3 4 5 6    反转 3  5   1 2 5 4 3   6
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        // 首先找到第left的前一个节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 此时prev指向left的前一个节点
        // 然后反转left-right
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(123);
        }
    }
}
