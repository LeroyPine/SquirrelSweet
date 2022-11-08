package com.squirrel.java.leet.listnode.meet;

import java.util.ArrayList;
import java.util.List;

public class 约瑟夫唤醒链表 {



    public static ListNode josephusKill(ListNode head, int m) {


        // 边界条件
        if (head == null || m<1){
            return head;
        }

        List<ListNode> list = new ArrayList<>();

        while (head!=null){
            list.add(head);
            head = head.next;
        }
        int size = list.size();

        // 转换为数组    假设当前要删除的节点为 idx
        int idx = 0;
        while (size>1){

            idx = (idx + m -1)%size;
            list.remove(idx);

            size--;
        }

        return list.get(0);



    }

    public static void main(String[] args) {


        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next=five;
       // five.next=one;
        ListNode listNode = josephusKill(one, 2);
        System.out.println(listNode);
    }

}
