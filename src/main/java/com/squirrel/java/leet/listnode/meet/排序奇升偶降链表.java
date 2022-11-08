package com.squirrel.java.leet.listnode.meet;

public class 排序奇升偶降链表 {

    public ListNode[] sortNode(ListNode head) {
        // 奇数节点
        ListNode odd = head;
        // 偶数头结点
        ListNode evenHead = head.next;
        // 引用变量进行推进
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 1 2  3  4
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = null;
        return new ListNode[]{head, evenHead};
    }

    // 然后反转偶数链表
    public ListNode reverse(ListNode node) {
        ListNode newHead = new ListNode(-1);
        while (node != null) {
            // 当前节点不为空
            ListNode next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = next;
            // 头插法
        }
        return newHead.next;
    }

    public ListNode mergeListNode(ListNode odd, ListNode even) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (odd != null && even != null) {
            int oddNum = odd.val;
            int evenNum = even.val;
            if (oddNum < evenNum) {
                curr.next = odd;
                odd = odd.next;
            } else {
                curr.next = even;
                even = even.next;
            }
            curr = curr.next;
        }
        if (odd != null) {
            curr.next = odd;
        }
        if (even != null) {
            curr.next = even;
        }
        return dummyNode.next;

    }
}
