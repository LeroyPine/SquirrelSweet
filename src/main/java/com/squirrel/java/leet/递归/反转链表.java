package com.squirrel.java.leet.递归;


public class 反转链表 {


    //  1 3 4 5 6


    public static ListNode reverseList2(ListNode head){
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        ListNode newList = reverseList2(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        //ListNode t1  = head.next;
        // 让 2 的 next 指向 2
       // t1.next = head;

        head.next.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;
    }


    public static void main(String[] args) {
        反转链表 a = new 反转链表();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
     /*   ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);*/

        one.next = two;
       /* two.next = three;
        three.next = four;*/
        ListNode reverse = a.reverseList2(one);
        System.out.println(reverse);
        
        
    }
}
