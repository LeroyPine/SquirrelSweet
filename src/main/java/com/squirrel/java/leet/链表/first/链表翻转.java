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
 * @date Created in 2021年05月14日 10:57
 * @since 1.0
 */
public class 链表翻转 {

    public static void main(String[] args) {

        初始化链表 init = new 初始化链表();
        for (int i = 0; i < 3; i++) {
            init.createListNode(i);
        }

        ListNode listNode = reverseDG(init.getHead());

        System.out.println(listNode);


    }


    /**
     * 递归压栈,要把每个栈帧执行完
     *
     * @param head
     * @return
     */

    public static ListNode reverseDG(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        ListNode newList = reverseDG(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        ListNode t1 = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;

        //  1  2  3   4  5
    }



}
