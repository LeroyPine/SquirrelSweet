package com.squirrel.java.leet.listnode.finals;


import com.squirrel.java.entity.ListNode;

/**
 * 合并列表节点
 *
 * @author luobaosong
 * @date 2022/09/06 07:37:30
 */
public class MergeListNodes {


    /**
     * 合并两个列表
     *
     * @param l1 l1
     * @param l2 l2
     * @return {@link ListNode}
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 比较两个链表的值并合并成一个新的
        ListNode dummyNode = new ListNode(-1);
        ListNode mergedListNode = dummyNode;

        while (l1 != null && l2 != null) {
            int num1 = l1.val;
            int num2 = l2.val;
            if (num1 < num2) {
                mergedListNode.next = new ListNode(num1);
                l1 = l1.next;
            } else {
                mergedListNode.next = new ListNode(num2);
                l2 = l2.next;
            }
            mergedListNode = mergedListNode.next;
        }
        if (l1 != null) {
            mergedListNode.next = l1;
        }
        if (l2 != null) {
            mergedListNode.next = l2;
        }
        return dummyNode.next;
    }

}
