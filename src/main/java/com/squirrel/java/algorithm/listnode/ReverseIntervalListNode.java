package com.squirrel.java.algorithm.listnode;

import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/8/10 16:28
 * @description 反转区间链表
 **/
@Slf4j
public class ReverseIntervalListNode {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseNListNode(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successorNode = null;

    private ListNode reverseNListNode(ListNode head, int n) {
        if (n == 1) {
            successorNode = head.next;
            return head;
        }
        ListNode last = reverseNListNode(head.next, n - 1);
        head.next.next = head;
        head.next = successorNode;
        return last;
    }


    /**
     * 穿针引线
     * ～ 先到达left节点,然后将left节点和right节点进行反转
     */
    public ListNode reverseBetweenByIterate(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 当前节点  1 3 4 5 6
        ListNode currentNode = prev.next;
        for (int i = 0; i < right - left; i++) {
            // 下一个节点
            ListNode next = currentNode.next;
            currentNode.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ReverseIntervalListNode instance = new ReverseIntervalListNode();
        ListNode reverseNode = instance.reverseBetweenByIterate(ListNode.init(), 2, 4);
        log.info("reverseNode:{}", JSON.toJSONString(reverseNode));
    }
}
