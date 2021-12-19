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
 * @date Created in 2021年05月15日 17:21
 * @since 1.0
 */
public class 两两交换链表中的节点 {


    /**
     * 思路:
     * 1. 两两互相交换
     *
     * @param head 链表节点
     * @return 交换后的节点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        // 定义一个哑结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;


        // 进行两两交换
        while (temp.next != null && temp.next.next != null) {
            ListNode curr = temp.next;
            ListNode nextNode = temp.next.next;
            // 节点指向第二个节点
            temp.next = nextNode;
            // 节点交换
            curr.next = nextNode.next;
            // 节点交换
            nextNode.next = curr;
            temp = curr;
        }
        return dummyNode.next;
    }
}
