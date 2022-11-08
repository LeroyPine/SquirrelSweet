package com.squirrel.java.algorithm.listnode;


import com.alibaba.fastjson.JSON;
import com.squirrel.java.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author luobaosong
 * @date 2022/8/8 15:32
 * @description 反转链表
 **/
@Slf4j
public class ReverseListNode {

    /**
     * 递归
     */
    public ListNode reverseListNodeByRecursion(ListNode head) {
        // 递归的base case
        if (head == null || head.next == null) {
            return head;
        }
        // 进行递归,并执行相应逻辑
        ListNode last = reverseListNodeByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 迭代
     */
    public ListNode reverseListNodeByIterate(ListNode head) {
        // 基础条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        // 采用一个哑节点来接收要进行反转的节点
        while (head != null) {
            ListNode next = head.next;
            head.next = preNode;
            preNode = head;
            head = next;
        }
        return preNode;
    }


    public static void main(String[] args) {
        ReverseListNode instance = new ReverseListNode();
        ListNode resultByRecursion = instance.reverseListNodeByRecursion(ListNode.init());
        log.info("resultByRecursion:{}", JSON.toJSONString(resultByRecursion));
        ListNode resultByIterate = instance.reverseListNodeByIterate(resultByRecursion);
        log.info("resultByIterate:{}", JSON.toJSONString(resultByIterate));


        List<String> list = Arrays.asList("a","a","a");

        System.out.println(list.stream().allMatch(s-> "a".equals(s)));

    }
}
