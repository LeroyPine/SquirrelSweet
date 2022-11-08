package com.squirrel.java.leet.listnode.meet;

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
 * @date Created in 2021年09月26日 16:33
 * @since 1.0
 */
public class 排序链表 {

    /**
     * 思路:
     * 1.采用归并排序
     * 2.然后在进行合并链表
     *
     * @param head 头结点
     * @return 合并后的链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 寻找链表中点
        ListNode middleNode = middle(head);
        ListNode middleTemp = middleNode.next;
        middleNode.next = null;

        return merge(sortList(head), sortList(middleTemp));

    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 != null) {
            curr.next = node1;
        }
        if (node2 != null) {
            curr.next = node2;
        }
        return dummyNode.next;
    }

    /**
     * 获取链表的中点
     *
     * @param head 头结点
     * @return 中节点
     */
    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
