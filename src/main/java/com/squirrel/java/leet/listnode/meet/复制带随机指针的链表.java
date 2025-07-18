package com.squirrel.java.leet.listnode.meet;

import java.util.HashMap;
import java.util.Map;

public class 复制带随机指针的链表 {


    /**
     * 思路:
     * 1.遍历head的每一个节点,将其放入一个hashMap中
     * 2.在遍历head取出其对应在hashMap中的节点
     * 3.然后完成拼接
     *
     * @param head 头结点
     * @return 拷贝后的链表
     */
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        // map集合
        Map<ListNode, ListNode> map = new HashMap<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            map.put(curr, new ListNode(curr.val));
        }
        for (ListNode curr = head; curr != null; curr = curr.next) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }
        return map.get(head);
    }


}