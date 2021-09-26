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
 * @date Created in 2021年05月14日 15:24
 * @since 1.0
 */
public class 移除链表元素 {

    public static void main(String[] args) {

        System.out.println(removeElements(ListNodeFactory.getSortListNode(), 2));
    }

    /**
     * 1 1 2 3 4
     * 移除链表中某个元素
     *
     * @param head
     * @param val
     * @return
     */

    public static ListNode removeElements(ListNode head, int val) {

        /// 定义一个哑结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curr = dummyNode;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;

    }
}
