package com.squirrel.java.algorithm.listnode;


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
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode();
            if (l1.val <= l2.val) {
                node.setVal(l1.val);
                l1 = l1.next;
            } else {
                node.setVal(l2.val);
                l2 = l2.next;
            }
            pre.next = node;
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummyNode.next;
    }

}
