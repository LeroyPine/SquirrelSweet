package com.squirrel.java.leet.链表;

import java.util.ArrayList;
import java.util.List;

///输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
public class 旋转链表Self {


    public static void main(String[] args) {
        ListNode fiveListNode = ListNodeFactory.getFiveListNode();
        ListNode listNode = rotateRight(fiveListNode, 2);
        System.out.println(listNode);

    }

    /**
     * 放入数组中。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode temp =head;

        List<ListNode> nodes = new ArrayList<>();

        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }
        // 同时向右移动k个
        // num =  5 个  move 3个
        // 坐标为2的
        // List<ListNode> newNodes = new ArrayList<>(nodes.size());
        ListNode[] newNodes = new ListNode[nodes.size()];
        if (nodes.size() == 1 || k <= 0) {
            return head;
        }
        if (k > nodes.size()) {
            k = k% (k - nodes.size());
        }

        // 5 - 2 = 3
        for (int i = 0; i < nodes.size(); i++) {

            int index = i + k;

            if (index >= nodes.size()) {
                newNodes[index - nodes.size()] = nodes.get(i);
            } else {
                newNodes[index] = nodes.get(i);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        for (ListNode newNode : newNodes) {
            curr.next = newNode;
            newNode.next = null;
            curr = curr.next;
        }
        return dummyNode.next;
    }
}
