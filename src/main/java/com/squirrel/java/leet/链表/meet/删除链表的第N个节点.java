package com.squirrel.java.leet.链表.meet;

public class 删除链表的第N个节点 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        for (int i = 0; i < n; i++) {
            first = first.next;
            second = second.next;
        }

        // 此时second 为第n各节点

        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return dummyNode.next;

    }


    /**
     * //使用双指针
     * <p>
     * ListNode dummyNode = new ListNode(-1, head);
     * <p>
     * // 使用双指针
     * <p>
     * <p>
     * ListNode first = head;
     * ListNode second = head;
     * <p>
     * // first 先走n
     * for (int i = 0; i < n; i++) {
     * first = first.next;
     * }
     * <p>
     * // second 在走n
     * <p>
     * while (first != null) {
     * <p>
     * first = first.next;
     * second = second.next;
     * }
     * <p>
     * <p>
     * if (second != null && second.next != null) {
     * second.next = second.next.next;
     * }
     * return dummyNode.next;
     */


    public ListNode removeNthFromEnd11(ListNode head, int n) {

        ListNode firstNode = head;
        ListNode secondNode = head;


        for (int i = 0; i < n; i++) {

            firstNode = firstNode.next;
        }

        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        if (secondNode != null && secondNode.next != null) {
            secondNode.next = secondNode.next.next;
        }

        return head;


    }


    public static ListNode removeByRatio(ListNode head, int a, int b) {

        // 删除 a/b
        if (a<1 || b >1 || head == null){
            return head;
        }
        // 公式  统计 链表格式
        int n = 0;
        ListNode temp = head;
        while (temp!=null){
            temp = temp.next;
            n++;
        }
        // 删除链表第几个节点
        int k =(int) Math.ceil((double) a * n /b);

        if (k ==1){
            return head.next;
        }

        ListNode ans = head;
        if (k>1){


            // 找到k的前去节点
            while (--k>1){
                ans = ans.next;
            }

            if (ans.next !=null){
                ans.next = ans.next.next;
            }
        }

        return head;
    }
}
