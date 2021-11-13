package com.squirrel.java.leet.链表.meet;

import java.util.List;

public class 排序奇升偶降列表 {


    public ListNode[] sortNode(ListNode head) {

        // 奇数节点
        ListNode odd = head;
        // 偶数头结点
        ListNode evenHead = head.next;
        // 引用变量进行推进
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 1 2  3  4
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        return new ListNode[]{head, evenHead};
    }

    // 然后反转偶数链表
    public ListNode reverse(ListNode node) {
        ListNode newHead = new ListNode(-1);
        while (node != null) {
            // 当前节点不为空
            ListNode next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = next;
            // 头插法
        }

        return newHead.next;
    }

    public ListNode mergeListNode(ListNode odd, ListNode even) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (odd != null && even != null) {
            int oddNum = odd.val;
            int evenNum = even.val;
            if (oddNum < evenNum) {
                curr.next = odd;
                odd = odd.next;
            } else {
                curr.next = even;
                even = even.next;
            }
            curr = curr.next;
        }
        if (odd != null) {
            curr.next = odd;
        }
        if (even != null) {
            curr.next = even;
        }
        return dummyNode.next;

    }


    public static void main(String[] args) {
        排序奇升偶降列表 a = new 排序奇升偶降列表();

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(8);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(6);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(4);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(2);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;


        ListNode[] listNodes = a.sortNode(one);

        ListNode odd = listNodes[0];
        ListNode even = listNodes[1];

        // 反转奇数
        ListNode reverse = a.reverse(even);


        ListNode listNode = a.mergeListNode(reverse, odd);


        System.out.println(listNode);
    }

}
