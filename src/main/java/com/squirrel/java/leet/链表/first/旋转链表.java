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

    public static void main(String[] args) {

    }
    //输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]


    public ListNode rotateRight(ListNode head, int k) {

        // 旋转链表思路
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        int n = 1;
        while (curr.next != null) {
            curr = curr.next;
            n++;
        }
        //  此时curr 为尾节点
        // 实际转动
        int add = n - k % n;
        if (add == n) {
            return head;
        }

        // 拼接
        curr.next = head;

        while (add-- > 0) {
            curr = curr.next;
        }

        // 找到新的节点
        ListNode ret = curr.next;
        curr.next = null;
        return ret;
    }
}
