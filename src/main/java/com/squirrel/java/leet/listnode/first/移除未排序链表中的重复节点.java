package com.squirrel.java.leet.listnode.first;

import java.util.HashSet;
import java.util.Set;

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
 * @date Created in 2021年05月14日 18:35
 * @since 1.0
 */
public class 移除未排序链表中的重复节点 {

    public static void main(String[] args) {

        System.out.println(removeDuplicateNodes(ListNodeFactory.getSortListNode()));

    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curr = dummyNode;

        Set<Integer> set = new HashSet<>();

        // 1 2 2 2
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.val);
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}
