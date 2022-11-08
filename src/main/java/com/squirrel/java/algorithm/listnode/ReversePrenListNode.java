package com.squirrel.java.algorithm.listnode;

import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luobaosong
 * @date 2022/8/8 16:10
 * @description 反转链表前N个节点
 **/
@Slf4j
public class ReversePrenListNode {

    ListNode successorNode = null;

    /**
     * 将链表的前 n 个节点反转（n <= 链表长度）
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successorNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successorNode;
        return last;
    }


    public static void main(String[] args) {
        ReversePrenListNode instance = new ReversePrenListNode();
        ListNode reverseN = instance.reverseN(ListNode.init(), 2);
        log.info("reverseN:{}", JSON.toJSONString(reverseN));
    }
}
