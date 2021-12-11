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
 * @date Created in 2021年05月14日 14:04
 * @since 1.0
 */
public class 删除链表中重复的元素 {

    /**
     * 思路:
     * 删除链表中重复的元素
     * 利用头节点,比较后续连续节点的值
     * 连续的  那么 直接比较当前与下一个的值
     * <p>
     * 1,2,2,3,4,4,5
     *
     * @param head 链表
     * @return 删除重复节点后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null) {
            int val = curr.next.val;
            // 连续元素值相同
            if (curr.next.val == curr.next.next.val) {
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }


}
