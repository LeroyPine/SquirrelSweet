package com.squirrel.java.leet.链表.first;

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
 * @date Created in 2021年05月17日 12:26
 * @since 1.0
 */
public class 旋转链表 {

    /**
     * 思路:
     * 1.计算旋转了几个元素,尾节点应该走几步
     *
     * @param head 头结点
     * @param k    旋转了几个元素
     * @return 返回旋转后的节点
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 旋转链表思路
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 计算链表的长度n
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        // 计算链表尾节点应该移动几位
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        // 尾节点接上头结点
        curr.next = head;
        while (add-- > 0) {
            curr = curr.next;
        }
        ListNode res = curr.next;
        curr.next = null;
        return res;
    }
}
