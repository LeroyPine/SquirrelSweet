package com.squirrel.java.leet.链表.meet;

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
 * @date Created in 2021年09月22日 20:19
 * @since 1.0
 */
public class 合并k个有序链表 {

    // 采用分而治之法
    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);

    }


    // 合并
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return merger2List(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode merge1(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (right > left) {
            return null;
        }
        int mid = (left + right) / 2;

        return merger2List(merge1(lists, left, mid), merge1(lists, mid + 1, right));

    }


    private ListNode merger2List(ListNode node1, ListNode node2) {

        // 合并两个有序链表
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1 == null) {
            curr.next = node2;
        }
        if (node2 == null) {
            curr.next = node1;
        }
        return dummyNode.next;
    }

}
