package com.squirrel.java.algorithm.listnode;

import com.squirrel.java.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/11/6 11:28
 * @description
 **/
@Slf4j
public class PartitionListNode {

    /**
     * 分割链表
     *
     * @param head 头
     * @param x    x
     * @return {@link ListNode}
     */
    public ListNode partition(ListNode head, int x) {
        // 将原链表根据x切割成两个链表
        // 然后将两个链表进行合并
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode p1 = dummyNode1;
        ListNode p2 = dummyNode2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 断掉p的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummyNode2.next;
        log.info("test plan");
        return dummyNode1.next;
    }
}
