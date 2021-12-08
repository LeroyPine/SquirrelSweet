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
 * @date Created in 2021年09月23日 10:11
 * @since 1.0
 */
public class 重排链表 {

    /**
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * //
     * 输入：head = [1,2,3,4,5]
     * 输出：[1,5,2,4,3]
     * // 取链表中点  + 反转链表  + 合并链表
     *
     * @param head 链表
     */

    public void reorderList(ListNode head) {
        // 为空返回
        if (head == null) {
            return;
        }
        // 找到链表的中点
        ListNode middleNode = middle(head);
        ListNode listNode2 = middleNode.next;
        // 反转middleNode
        ListNode reverseNode = reverseListNode(listNode2);
        // 切断
        middleNode.next = null;
        // 合并两个链表
        mergeNode(head, reverseNode);

    }

    private void mergeNode(ListNode head, ListNode reverseNode) {
        ListNode tempA;
        ListNode tempB;
        while (head != null && reverseNode != null) {
            // 取出两个链表的下一个节点的快照
            tempA = head.next;
            tempB = reverseNode.next;

            // 下一个节点设置为对应的节点
            head.next = reverseNode;
            head = tempA;

            reverseNode.next = head;
            reverseNode = tempB;
        }
    }

    // 反转链表
    private ListNode reverseListNode(ListNode node) {
        // 采用头插法来反转链表  1 2 3
        ListNode head = new ListNode(-1);
        while (node != null) {
            ListNode next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        return head.next;

    }

    // 获取链表的中点  1 2 3 4 5   1  2  2 4
    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
