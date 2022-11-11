package com.squirrel.java.algorithm.listnode;

import com.squirrel.java.entity.ListNode;

/**
 * @author luobaosong
 * @date 2022/10/7 15:00
 * @description
 **/
public class DetectCycleNode {


    /**
     * 获取环的起点
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast;
        ListNode slow;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 相交节点break
            if (slow == fast) {
                break;
            }
        }
        // 证明没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

}
