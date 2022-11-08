package com.squirrel.java.leet.listnode.meet;

import java.util.Deque;
import java.util.LinkedList;

public class 判断回文链表 {


    /**
     * 是否是会问链表
     * @param head
     * @return
     */
    public boolean isHuiW(ListNode head){
        if(head == null || head.next == null)
            return true;
        // 使用栈 - 来存储弹出    1  2  3  4  5  6

        Deque<ListNode> stack = new LinkedList<>();

        // 找到链表的一半
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时 slow 为 链表的一半
        // 进行压栈

        while (slow!=null){
            stack.push(slow);
            slow = slow.next;
        }

        // stack 弹栈
        ListNode temp = head;

        while (!stack.isEmpty()){

            if (stack.pop() != temp){
                return false;
            }
            temp = temp.next;
        }
        return true;

    }

}
