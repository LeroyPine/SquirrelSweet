package com.squirrel.java.leet.链表.meet;

public class 反转链表 {



    // 反转链表：
    // 1 - 2  3   4
    // 4 - 3 - 2 -1     思路：将每个节点的指针指向上一个节点即可。
    public ListNode reverseNode(ListNode node){

        ListNode next =null;
        ListNode pre = null;

        while (node != null){

            // 当前结点的下一个节点  临时变量
            next = node.next;
            // 当前节点指向上一个节点
            node.next = pre;
            // 转移得到next 节点
            pre = node;
            //
            node = next;
        }
        return pre;

    }


    // 部分节点反转  -- 首先找到from前面的一个节点   5  7
    public ListNode reverseNode(ListNode node,int from,int to){

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = node;
        ListNode prev = dummyNode;

        for (int i = 0; i < from-1; i++) {
            prev = prev.next;
        }
        // 此时prev 为 要反转节点的前一个节点

        ListNode curr = prev.next;

        //  3  4  5    5   2  4

        for (int i = 0; i < to - from ; i++) {
            // 3个结点实现反转  3  4 5 6

            // 存储临时节点  当前节点的下一个节点
            ListNode next = curr.next;
            // 当前节点的下一个节点为下下个结点
            curr.next = next.next;
            // 下一个节点指向 当前节点
            next.next = prev.next;
            // 前一个节点指向下一个节点
            prev.next = next;

        }

        return dummyNode.next;

    }

    public static void main(String[] args) {
        反转链表 a = new 反转链表();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
      //  ListNode listNode = a.reverseNode(one);
        // System.out.println(listNode );;
/*
        ListNode listNode1 = a.reverseNode(one, 2, 3);
        System.out.println(listNode1);*/

        ListNode listNode = reverseList2(one);
        System.out.println(listNode);
    }


    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //递归反转子lian链表
        ListNode newList = reverseList2(head.next);
        //第三张图
        head.next.next = head;
        head.next = null;
        return newList;
    }
}
