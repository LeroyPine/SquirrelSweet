package com.squirrel.java.leet.listnode.meet;

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

    /**
     * 思路:
     * 1.分而治之,将一个集合拆分开,最后在进行合并。
     *
     * @param lists 链表集合
     * @return 合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwo(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    // 合并两个有序链表
    private ListNode mergeTwo(ListNode listNode1, ListNode listNode2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                curr.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                curr.next = listNode2;
                listNode2 = listNode2.next;
            }
            curr = curr.next;
        }
        if (listNode1 != null) {
            curr.next = listNode1;
        }
        if (listNode2 != null) {
            curr.next = listNode2;
        }
        return dummyNode.next;
    }

}
