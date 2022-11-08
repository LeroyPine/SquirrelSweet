package com.squirrel.java.leet.listnode.first;

import java.util.ArrayList;
import java.util.List;

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
 * @date Created in 2021年05月14日 15:48
 * @since 1.0
 */
public class 链表的中间节点 {


    /**
     * 如果是偶数返回第二个
     * 奇数返回中间
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        List<ListNode> nodes = new ArrayList<>();


        while (head != null) {

            nodes.add(head);
            head = head.next;
        }
        ListNode middleNode = nodes.get(nodes.size() / 2);
        // 1 2 3 4 5 6 7 8  5   --4
        // 1 2 3 4 5 6 7    2   --4
     /*   if (nodes.size() % 2 == 0) {
            middleNode = nodes.get(nodes.size() / 2);
        } else {
            middleNode = nodes.get(nodes.size() / 2);
        }*/


        return middleNode;
    }

}
