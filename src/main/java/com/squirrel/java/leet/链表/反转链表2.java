package com.squirrel.java.leet.链表;

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
 * @date Created in 2021年05月08日 10:58
 * @since 1.0
 */
public class 反转链表2 {
    //  1 - 2 - 3 - 4 - 5
    //  1 - 3 - 2 - 4 - 5

    // 切割 2 3

    // 找到left以及right所在的节点
    // 进行切割 将中间的链表截取出来
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        // 定义一个哑结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        // 找到left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode rightNode = prev;
        // 在遍历找到rightNode
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 进行要反转的子链表截取
        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;
        // 切断联系
        prev.next = null;
        rightNode.next = null;

        reverse(leftNode);

        // 进行拼接
        prev.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;


    }

    // reverse
    public static ListNode reverse(ListNode listNode) {
        // 链表反转  、定义Temp
        ListNode prev = null;
        ListNode curr = listNode;

        while (curr != null) {

            // 取出next （new Obj）
            ListNode next = curr.next;
            // 当前节点的下一个节点
            curr.next = prev;
            // 将prev转换成当前节点
            prev = curr;
            // 再将curr替换成原先的next对象
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {

        初始化链表 a = new 初始化链表();
        for (int i = 0; i < 7; i++) {
            a.createListNode(i);
        }
        System.out.println(a.getHead());

        ListNode listNode = reverseBetween(a.getHead(), 2, 4);

        /*ListNode reverse = reverse(a.getHead());*/
        System.out.println(listNode);



/*        ListNode reverse = reverse(a.getHead());
        System.out.println(reverse);*//*
        Solution solution = new Solution();
        //ListNode listNode = solution.reverseBetween(a.getHead(), 2, 4);
        ListNode listNode = reverseBetween(a.getHead(), 2, 4);
        System.out.println(listNode);*/


    }

    public ListNode reverseBetweenII(ListNode head, int left, int right) {

        //

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        // 先走到left
        // 0 1 2

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        // 再走到right
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // leftNode
        ListNode leftNode = prev.next;
        ListNode ofNode = rightNode.next;
        prev.next = null;
        rightNode.next = null;

        reverse(leftNode);

        prev.next = rightNode;
        leftNode.next = ofNode;



        return dummyNode.next;
    }


    static class Solution {


        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;

            ListNode pre = dummyNode;
            // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
            // 建议写在 for 循环里，语义清晰

            //-1  012345  2个    2,4     1 3
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
            ListNode rightNode = pre;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            // 第 3 步：切断出一个子链表（截取链表）
            ListNode leftNode = pre.next;
            ListNode curr = rightNode.next;

            // 注意：切断链接
            pre.next = null;
            rightNode.next = null;

            // 第 4 步：同第 206 题，反转链表的子区间
            reverseLinkedList(leftNode);

            // 第 5 步：接回到原来的链表中
            pre.next = rightNode;
            leftNode.next = curr;
            return dummyNode.next;
        }

        private void reverseLinkedList(ListNode head) {
            // 也可以使用递归反转一个链表
            ListNode pre = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }

}
