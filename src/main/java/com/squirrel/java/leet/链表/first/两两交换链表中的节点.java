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


    public static void main(String[] args) {

    }


    /**
     * 两两交换
     * 妹两组一交换
     * 1 2 3 4 5 6 7
     *
     * @param head
     * @return
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
            // 第一个节点
            ListNode node = temp.next;
            // 第二个节点
            ListNode nextNode = temp.next.next;
            node.next = nextNode.next;
            // 节点置为第二个
            temp.next = nextNode;
            // 进行交换
            nextNode.next = node;
            temp = node;
        }
        return dummyNode.next;
    }
}
