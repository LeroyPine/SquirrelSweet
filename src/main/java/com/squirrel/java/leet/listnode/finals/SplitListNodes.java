package com.squirrel.java.leet.listnode.finals;


import com.squirrel.java.entity.ListNode;

/**
 * 分割链表
 *
 * @author luobaosong
 * @date 2022/09/06 07:37:30
 */
public class SplitListNodes {


    /**
     * 分裂节点列表
     * 分隔链表
     *
     * @param head 列表节点
     * @param x    x
     * @return {@link ListNode}
     */
    public ListNode splitListNodes(ListNode head, int x) {
        /*
         * 将链表分隔成两个链表,一个大于x,一个小于x
         */
        if (head == null) {
            return null;
        }
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-2);
        // ~
        ListNode prev1 = dummyNode1;
        ListNode prev2 = dummyNode2;
        while (head != null) {
            int val = head.val;
            if (val < x) {
                prev1.next = new ListNode(val);
                prev1 = prev1.next;
            } else {
                prev2.next = new ListNode(val);
                prev2 = prev2.next;
            }
            head = head.next;
        }
        prev1.next = dummyNode2.next;

        return dummyNode1.next;
    }

}
