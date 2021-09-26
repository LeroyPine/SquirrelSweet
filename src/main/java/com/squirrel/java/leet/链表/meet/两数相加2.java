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
 * @date Created in 2021年07月13日 18:50
 * @since 1.0
 */
public class 两数相加2 {

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * <p>
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 9 -> 7
     * <p>
     * 3 4 2 7
     * 4 5 6 0
     *
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 进行链表的翻转 在进行相加
        ListNode re1 = reverse(l1);
        ListNode re2 = reverse(l2);

        // 定义一个进位
        ListNode dummyNode = new ListNode(-1);

        ListNode currNode = dummyNode;

        int carry = 0;
        // 两数相加
        while (re1 != null || re2 != null) {
            int re1Num = re1 != null ? re1.val : 0;
            int re2Num = re2 != null ? re2.val : 0;
            int result = re1Num + re2Num + carry;

            carry = result / 10;

            currNode.next = new ListNode(result % 10);
            currNode = currNode.next;

            if (re1 != null) {
                re1 = re1.next;
            }
            if (re2 != null) {
                re2 = re2.next;
            }
        }

        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }


        return dummyNode.next;
    }

    private ListNode reverse(ListNode head) {

        // 链表翻转头插法
        ListNode headNode = new ListNode(-1);


        ListNode curr = head;
        // 当前节点不为空的情况下
        while (curr != null) {
            // 下一个节点
            final ListNode next = curr.next;

            curr.next = headNode;

            headNode.next = curr;

            curr = next;

        }


        return head;
    }

}
