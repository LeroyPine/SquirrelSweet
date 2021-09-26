package com.squirrel.java.leet.链表.first;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author luobs
 * @version 1.0
 * @date Created in 2021年04月02日 10:46
 * @since 1.0
 */
@Slf4j
public class 删除链表第N个节点 {

    public static void main(String[] args) {
        // init
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;


        log.info("【通过双指针进行删除链表的节点: start】");
        ListNode listNode5 = removeNthFromEnd(listNode, 5);
        System.out.println(listNode5);
        log.info("【通过双指针进行删除链表的节点: end :{}】", JSONObject.toJSONString(listNode5));

        log.info("【通过栈进行删除链表的节点: start】");
        ListNode listNode6 = removeNthFromEndUseStack(listNode, 3);
        System.out.println(listNode6);
        log.info("【通过栈进行删除链表的节点: end: {}】", JSONObject.toJSONString(listNode5));

    }


    /**
     * 是否需要考虑  链表长度为2  n大于2的这种异常情况
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 定义一个哑节点
        ListNode dummy = new ListNode(0, head);
        // 双指针
        ListNode first = head;
        ListNode second = dummy;

        // 第一个指针先走N ，第二个和第一个在一起走
        for (int i = 0; i < n; i++) {
            if (first.next == null) {
                break;
            }
            first = first.next;
        }
        // 走到first走完
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        if (second.next != null) {
            second.next = second.next.next;
        }
        return dummy.next;
    }


    public static ListNode removeNthFromEndUseStack(ListNode head, int n) {
        // 定义 一个伪节点  （当做头结点  避免多余的判断头节点是否存在）
        ListNode dummy = new ListNode(0, head);
        // 声明一个栈
        Deque<ListNode> stack = new LinkedList<>();

        ListNode cur = dummy;

        // 压栈
        while (cur.next != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 查找第n个
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // 获取栈的第一个元素
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }


    // 删除倒数第N个节点   中间差保持N距离
    // 可以采用双指针  快慢指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;

        // fast 先走N
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        // slow 和 fast一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 切断倒数第N个节点

        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummyNode.next;
    }
}
