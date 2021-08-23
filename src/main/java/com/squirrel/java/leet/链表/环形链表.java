package com.squirrel.java.leet.链表;

import java.util.HashSet;
import java.util.Set;

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
 * @date Created in 2021年04月17日 14:27
 * @since 1.0
 */
public class 环形链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(10);

        ListNode l1 = new ListNode(0);
        l1.next = n1;
        n1.next = n2;
        n2.next = n3;

        // 构建环形链表

        boolean b = hasCycle(l1);
        boolean b1 = hasCycleSelf(l1);
        System.out.println(b);
        System.out.println(b1);

    }


    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null) {
            return false;
        }
        while (head.next != null) {

            if (!set.add(head)) {
                return true;
            }
            head = head.next;

        }
        return false;
    }

    public static boolean hasCycleV2(ListNode head) {
        // 相互追逐
        if (head == null || head.next == null) {
            return false;
        }

        // 1.2
        ListNode slow = head;
        ListNode fast = head.next;

        // 如果 slow 不相遇 fast 那么就没有环

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }




    public static  boolean hasCycleSelf(ListNode head){
        // 是否有环  1.set 节点相同加入不进去
        if (head == null){
            return false;
        }

        Set<ListNode> set  = new HashSet<>();

        while (head != null){

            if (!set.add(head)){
                return true;
            }
            set.add(head);
            head = head.next;

        }
        return false;
    }

}
