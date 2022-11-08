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
 * @date Created in 2021年07月13日 15:28
 * @since 1.0
 */
public class 两数相加 {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     * <p>
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     * <p>
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */

    public static void main(String[] args) {
        // init
        ListNode listNode = new ListNode(8);
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);


        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        listNode8.next = listNode9;

        ListNode listNode15 = new ListNode(9);


        System.out.println("两数相加:" + addTwoNumbers(listNode, listNode15));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 末位相加

        ListNode dummyNode = new ListNode(0);

        ListNode te = dummyNode;
        int jw = 0;
        while (l1 != null || l2 != null) {


            // 位数不够时进行补0
            int l1num = l1 != null ? l1.val : 0;
            int l2num = l2 != null ? l2.val : 0;

            int result = l1num + l2num + jw;

            jw = result / 10;
            int ys = result % 10;

            ListNode temp = new ListNode(ys);
            temp.val = ys;
            te.next = temp;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            te = te.next;

        }

        if (jw > 0) {
            te.next = new ListNode(jw);
        }

        return dummyNode.next;
    }

}
