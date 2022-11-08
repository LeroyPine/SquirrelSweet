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
 * @date Created in 2021年05月14日 14:28
 * @since 1.0
 */
public class ListNodeFactory {


    public static ListNode getSortListNode() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode two1 = new ListNode(2);
        ListNode two2 = new ListNode(2);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode five1 = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = two1;
        two1.next = two2;
        two2.next = three;
        three.next = four;
        four.next = five;
        five.next = five1;
        five1.next = six;

        return one;

    }

    public static ListNode getFiveListNode() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;

        three.next = four;
        four.next = five;


        return one;

    }


}
