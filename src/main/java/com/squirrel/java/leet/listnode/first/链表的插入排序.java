package com.squirrel.java.leet.listnode.first;

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
 * @date Created in 2021年06月01日 09:00
 * @since 1.0
 */
public class 链表的插入排序 {


    // 插入排序
    // 1 3 6 1 1 4 4 5
    // 选取一个中轴点,将每个元素进行移位
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 定义一个已经排序部分的最后一个节点

        ListNode dummyNode = new ListNode(-1, head);
        ListNode lastNode = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (lastNode.val <= curr.val) {
                lastNode = lastNode.next;
            } else {

                ListNode prev = dummyNode;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastNode.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastNode.next;
        }
        return dummyNode.next;
    }


    // 如何交换链表的两个节点
    public static void main(String[] args) {
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(12);

        a.next = b;
        b.next = c;

        // -1 3 12

        a.next = c;
        c.next = b;
        b.next = null;

        System.out.println(a);
    }

    {




    }
}
