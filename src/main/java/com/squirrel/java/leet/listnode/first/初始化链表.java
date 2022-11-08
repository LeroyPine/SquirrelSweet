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
 * @date Created in 2021年04月17日 12:30
 * @since 1.0
 */
public class 初始化链表 {

    // 头节点
    private ListNode head;
    // 临时节点
    private ListNode temp;


    /**
     * 创建链表
     *
     * @param val v
     * @return re
     */
    public  ListNode createListNode(Integer val) {

        if (head == null) {
            head = new ListNode(val);
            temp = head;
        } else {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        //
        return head;
    }


    public static void main(String[] args) {

        初始化链表 s = new 初始化链表();

        for (int i = 0; i < 4; i++) {
          s.createListNode(i);
        }
        System.out.println(s.head);
    }

    public ListNode getHead() {
        return head;
    }

    public ListNode getTemp() {
        return temp;
    }
}
