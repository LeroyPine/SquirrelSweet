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
 * @date Created in 2021年04月16日 09:30
 * @since 1.0
 */
public class ClassPoint {

    public static void main(String[] args) {


        ListNode listNode = new ListNode(2);

        ListNode prev = listNode;

        prev.next = new ListNode(3);

        System.out.println(listNode == prev);

        System.out.println(listNode.next == prev.next);
        //
        prev = prev.next;


        prev = new ListNode(4);

        System.out.println(listNode == prev);

    }
}
