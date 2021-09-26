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
 * @date Created in 2021年04月17日 10:18
 * @since 1.0
 */
public class 合并两个有序链表 {

    /**
     * 想法： 取每个链表的头结点进行比较 哪个小就将哪个放入到新链表中
     */


    public static void main(String[] args) {

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(10);

        ListNode l1 = new ListNode(0);
        l1.next = n1;
        n1.next = n2;
        n2.next = n3;

        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(5);

        ListNode l2 = new ListNode(0);
        l2.next = p1;
        p1.next = p2;
        p2.next = p3;


        ListNode listNode = mergeTwoLists(l1, l2);

        System.out.println(listNode);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 一直遍历到链表无节点

        ListNode finalNode = new ListNode(0);

        ListNode temp = finalNode;

        while (l1 != null && l2 != null) {

            int l1Val = l1.val;
            int l2Val = l2.val;

            if (l1Val <= l2Val) {
                temp.val = l1Val;
                temp.next = l1;
                l1 = l1.next;

            } else {
                temp.val = l2Val;
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // 如果某个链表已经为空 那么将其直接拼接到新的链表后面

        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }

        return finalNode.next;
    }

}
