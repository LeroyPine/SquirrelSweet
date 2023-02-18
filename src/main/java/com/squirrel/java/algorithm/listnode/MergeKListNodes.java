package com.squirrel.java.algorithm.listnode;

import com.squirrel.java.entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个节点
 *
 * @author luobaosong
 * @date 2022/11/6 20:27
 * @description
 **/
public class MergeKListNodes {


    /**
     * 主要是寻找最小的节点,然后依次拼接上
     * 可以采用优先队列的方式,保证每次取出的值是最小的
     *
     * @param lists 列表
     * @return {@link ListNode}
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        // 声明一个优先队列,
        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        // 将链表的头节点放入优先队列
        for (ListNode item : lists) {
            if (item != null) {
                priorityQueue.add(item);
            }
        }
        ListNode dummyNode = new ListNode();
        ListNode prev = dummyNode;

        while (!priorityQueue.isEmpty()) {
            ListNode head = priorityQueue.poll();
            if (head.next != null) {
                priorityQueue.add(head.next);
            }
            prev.next = head;
            prev = prev.next;
        }
        return dummyNode.next;
    }

}
